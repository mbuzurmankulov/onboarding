package com.epam.dela.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(driverClassName);
        source.setUsername(username);
        source.setPassword(password);
        source.setUrl(url);
        return  source;
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:migrations/changelog.xml");
        liquibase.setDataSource(dataSource());
        return liquibase;
    }
}
