package com.epam.dela.dao.impl

import com.epam.dela.MainApp
import com.epam.dela.config.TestDataLayerConfig
import com.epam.dela.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.jdbc.Sql
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import javax.transaction.Transactional

@SpringBootTest(classes = MainApp)
@Transactional //notifies Spring that there will be transactions in this test suite
class UserDaoImplIT extends Specification {

    @Autowired UserDaoImpl dao

    /*@ClassRule
    public static PostgreSQLContainer postgresqlServer = new PostgreSQLContainer("postgres:11.1")
            .withExposedPorts(10003)
            .withEnv("POSTGRES_DB", "test")
            .withEnv("POSTGRES_USER", "postgres")
            .withEnv("POSTGRES_PASSWORD", "postgres")*/

    @Rollback //rolls back whatever database changes were done during the test, effectively isolating this test from others
    @Sql("init-users.sql") //sql which is run before test
    def "test new user creation" () {
        given:
            def user = new User()
            user.setLogin("testLogin")
            user.setPassword("testPassword")
            user.setFirstName("testFirstName")
            user.setLastName("testLastName")
        when:
            def result = dao.create(user)
        then:
            result.getId() != null
    }

    @TestConfiguration
    @Import(TestDataLayerConfig)
    static class TestConfig{
        private DetachedMockFactory factory = new DetachedMockFactory()

        @Bean
        UserDaoImpl userDao() {
            factory.Mock(UserDaoImpl)
        }

    }

}
