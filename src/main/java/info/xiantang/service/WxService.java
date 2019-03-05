package info.xiantang.service;

import info.xiantang.utils.RedisUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class WxService {
    @Autowired
    private RedisUtil redisUtil;


    public String create3rdSession(String wxOpenId, String wxSessionKey, Long expires){
        String thirdSessionKey = RandomStringUtils.randomAlphanumeric(64);
        StringBuffer sb = new StringBuffer();
        sb.append(wxSessionKey).append("#").append(wxOpenId);
        redisUtil.add(thirdSessionKey, expires, sb.toString());
        return thirdSessionKey;
    }
}
