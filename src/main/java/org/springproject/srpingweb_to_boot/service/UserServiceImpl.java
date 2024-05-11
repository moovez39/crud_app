package org.springproject.srpingweb_to_boot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springproject.srpingweb_to_boot.dao.UserDao;
import org.springproject.srpingweb_to_boot.model.User;

import java.util.List;

@Service
//@Transactional
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    public void addUser(User user){
        userDao.add(user);
    }
    @Transactional
    public List<User> getUsers(){
        return userDao.getUsers();
    }
    @Transactional
    public void editUser(User user){userDao.editUser(user);}
    @Transactional
    public void removeUser(int id) {
        userDao.removeUser(id);
    }
    @Transactional
    public User findUser(int id){
        return userDao.findUser(id);
    }


}
