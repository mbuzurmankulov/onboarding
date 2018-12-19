package com.epam.dela.controller;

import com.epam.dela.dao.UserDao;
import com.epam.dela.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * Get list of all {@link User} by page and size. If any of the params null or less than 0 return all
     * @param page page of pagination
     * @param size size of a page
     * @return
     */
    @RequestMapping
    public List<User> getUserList(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size){
        return userDao.getAllUsers(page, size);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return userDao.create(user);
    }
}
