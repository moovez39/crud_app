package org.springproject.srpingweb_to_boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springproject.srpingweb_to_boot.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getUsers() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void removeUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void editUser(User updatedUser) {
        entityManager.merge(updatedUser);

    }

    @Override
    public User findUser(int id) {
        return entityManager.find(User.class, id);
    }

}
