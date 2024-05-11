package web.service;

import web.model.User;

public interface UserService {
    void addUser(User user);
    void removeUser(int id);
    void editUser(User updateUser);
    User findUser(int id);
}
