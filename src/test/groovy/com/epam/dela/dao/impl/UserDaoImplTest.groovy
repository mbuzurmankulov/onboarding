package com.epam.dela.dao.impl

import com.epam.dela.domain.User
import spock.lang.Specification

import javax.persistence.EntityManager

class UserDaoImplTest extends Specification{

    private UserDaoImpl userDao;

    private EntityManager entityManager;

    //this method is executed before every test. It does not need any annotations. It is detected by method name
    def setup() {
        entityManager = Mock(EntityManager.class);
        userDao = new UserDaoImpl();
        userDao.setEntityManager(entityManager);
    }

    def "simple test" (){
        given:
            def str = "str";
        when:
            def result = str.concat("1");
        then:
            result == "str1";
    }

    def "test entity manager invocation" () {
        given:
            def user = new User();
        and:
            entityManager.persist(user) >> user
        when:
            def resultUser = userDao.create(user);
        then:
            resultUser == user;
            1*entityManager.persist(user);
    }
}
