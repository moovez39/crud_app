package org.springproject.srpingweb_to_boot.dao;



import org.springproject.srpingweb_to_boot.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> getUsers();
    void removeUser(int id);
    void editUser(User user);
    User findUser(int id);
}