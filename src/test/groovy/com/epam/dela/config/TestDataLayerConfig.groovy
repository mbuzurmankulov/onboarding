package com.epam.dela.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.datasource.DriverManagerDataSource

//@TestConfiguration
class TestDataLayerConfig {
    @Value('${jdbc.driverClassName}')
    private String driverClassName
    @Value('${jdbc.username}')
    private String username
    @Value('${jdbc.password}')
    private String password
    @Value('${jdbc.url}')
    private String url

    @Bean
    DriverManagerDataSource dataSource(){
        DriverManagerDataSource source = new DriverManagerDataSource()
        source.setDriverClassName(driverClassName)
        source.setUsername(username)
        source.setPassword(password)
        source.setUrl(url)
        return  source
    }
}
