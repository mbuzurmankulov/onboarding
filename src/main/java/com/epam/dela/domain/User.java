package com.epam.dela.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
}
