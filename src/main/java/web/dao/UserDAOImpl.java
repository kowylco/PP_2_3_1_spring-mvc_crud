package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Component
public class UserDAOImpl implements UserDAO{
    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public void updateUserByID(int id, User user) {
        em.merge(user);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        Query q = em.createQuery("DELETE FROM User WHERE id=:id");
        q.setParameter("id", id).executeUpdate();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return em.createQuery("select user from User user", User.class).getResultList();
    }
}
