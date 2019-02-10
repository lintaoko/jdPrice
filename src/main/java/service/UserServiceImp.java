package service;

import dao.UserMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImp implements UserService {

    private UserMapper userMapper;

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
}
