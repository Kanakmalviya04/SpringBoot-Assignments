package com.kanakM.UMS.api;

import com.kanakM.UMS.modal.User;
import com.kanakM.UMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user){

        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable("userId") int userId){
        return userService.getUser(userId);
    }

    @PutMapping(value = "/{userId}")
    public User updateUserInfo(@PathVariable("userId") int userId, @RequestBody User user){
        return userService.updateUserInfo(userId, user);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable("userId") int userId){
        userService.deleteUser(userId);
    }
}
