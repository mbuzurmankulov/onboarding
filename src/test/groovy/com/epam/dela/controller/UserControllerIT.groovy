package com.epam.dela.controller

import com.epam.dela.dao.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.mock.DetachedMockFactory

@WebMvcTest(controllers = [UserController])
class UserControllerIT extends  Specification{

    @Autowired MockMvc mvc

    @Autowired UserDao userDao

    def "test new user creation" () {
        given:
            String s = "";
        when:
            String result = s.concat("1")
        then:
            result == "1"
    }

    @TestConfiguration
    static class StubConfig {
        DetachedMockFactory detachedMockFactory = new DetachedMockFactory()

        @Bean
        UserDao userDao() {
            return detachedMockFactory.Stub(UserDao)
        }
    }
}
