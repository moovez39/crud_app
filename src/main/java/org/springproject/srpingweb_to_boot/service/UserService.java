package org.springproject.srpingweb_to_boot.service;


import org.springproject.srpingweb_to_boot.model.User;

public interface UserService {
    void addUser(User user);
    void removeUser(int id);
    void editUser(User updateUser);
    User findUser(int id);
}
