package com.epam.dela.dao.impl;

import com.epam.dela.dao.UserDao;
import com.epam.dela.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAllUsers(Integer page, Integer size) {
        Query query = entityManager.createQuery("FROM " +
                "User");
        if(page != null && page < 0 && size != null && size < 0) {
                query.setFirstResult(page * size)
                    .setMaxResults(size);
        }
            return query.getResultList();
    }

    @Override
    @Transactional
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }
}
