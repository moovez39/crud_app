package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;
    public void addUser(User user){
        userDao.add(user);
    }
    public List<User> getUsers(){
        return userDao.getUsers();
    }
    public void editUser(User user){userDao.editUser(user);}
    public void removeUser(int id) {
        userDao.removeUser(id);
    }


}
