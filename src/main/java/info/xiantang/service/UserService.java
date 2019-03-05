package info.xiantang.service;

import info.xiantang.model.User;

public interface UserService {
    

    User selectById(int id);

    User saveUser(User user);

    int deleteUserById(String email);

    Boolean login(String user);
}
