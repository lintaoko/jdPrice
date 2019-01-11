package service;

import model.User;

public interface UserService {
    User selectById(int id);
}
