package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.UserDataDao;
import com.techelevator.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
//@PreAuthorize("isAuthenticated()")
@PreAuthorize("permitAll()")
@CrossOrigin
public class UserDataController {

    @Autowired
    private UserDataDao userDataDao;

    @Autowired
    private UserDao userDao;


    @RequestMapping(path = "/userdata", method = RequestMethod.GET)
    public UserData getUserDataById(Principal principal){
        System.out.println(principal.getName());
        return userDataDao.getUserData(userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/userdata", method = RequestMethod.PUT)
    public UserData updateUserData(@RequestBody UserData userData){
        return userDataDao.updateUserData(userData);
    }
}
