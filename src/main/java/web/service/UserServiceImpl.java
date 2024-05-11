package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

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
