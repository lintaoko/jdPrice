package service;

import model.User;

public interface UserService {
    User selectById(int id);

    User saveUser(User user);

    int deleteUserById(String email);

}
