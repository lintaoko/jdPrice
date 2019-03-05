package info.xiantang.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import info.xiantang.dao.UserMapper;
import info.xiantang.exception.ErrCodeException;
import info.xiantang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service("userService")
public class UserServiceImp implements UserService {

    private UserMapper userMapper;
    private  String wxspAppid = "wxc06f3f0a5ad54c8e";
    private  String wxspSecret = "b857124d1d72ee75e598293e70f313cf";
    @Autowired
    private WxService wxService;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User saveUser(User user) {
        this.userMapper.saveUser(user.getUserName(), user.getPassWord(), user.getEmail());
        return user;
    }


    @Override
    public User selectById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public int deleteUserById(String email) {
        return this.userMapper.deleteByEmail(email);
    }

    @Override
    public Boolean login(String code) throws ErrCodeException{
        RestTemplate restTemplate = new RestTemplate();// 发送request请求
        String params = "appid=" + wxspAppid +
                "&secret=" + wxspSecret +
                "&js_code=" +code+"&grant_type=authorization_code";//参数

        String url = "https://api.weixin.qq.com/sns/jscode2session?"+params;// 微信接口 用于查询oponid
        String response = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        Map<String, String> retMap = gson.fromJson(response,
                new TypeToken<Map<String, String>>(){}.getType());
        if (retMap.get("errcode").equals("40029")){
            throw new ErrCodeException();
        }
        String wxOpenId =retMap.get("openid");
        String wxSessionKey =retMap.get("session_key");
        long expires = 3600;
        wxService.create3rdSession(wxOpenId, wxSessionKey, expires);
        return true;
    }
}
