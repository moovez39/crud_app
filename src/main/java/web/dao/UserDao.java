package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> getUsers();
    void removeUser(int id);
    void editUser(User user);
    User findUser(int id);
}