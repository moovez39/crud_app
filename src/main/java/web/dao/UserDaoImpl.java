package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
//        user.setUsername("akdsdka");
    }

    @Override
    public List<User> getUsers() {

        return entityManager.createQuery("from User",User.class).getResultList();
    }

    @Override
    public void removeUser(int id) {
        entityManager.createQuery("delete User where User.id = id");
    }

    @Override
    public void editUser(User user){
        User update = entityManager.find(User.class,user);
        update.setUsername("edited username");
        entityManager.merge(update);
    }

}
