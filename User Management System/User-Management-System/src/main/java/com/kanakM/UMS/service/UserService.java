package com.kanakM.UMS.service;

import com.kanakM.UMS.modal.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class UserService {

    private int userIdCount = 1;
    private List<User> Userlist = new CopyOnWriteArrayList<>();
    public User addUser(User user){
        user.setUserId(userIdCount);
        Userlist.add(user);
        userIdCount++;
        return user;
    }

    public List<User> getAllUsers(){
        return Userlist;
    }

    public User getUser(int userId){
        return Userlist
                .stream()
                .filter(c -> c.getUserId() == userId)
                .findFirst()
                .get();
    }

    public User updateUserInfo(int userId, User user){
        Userlist
                .stream()
                .forEach(c -> {
                    if(c.getUserId() == userId) {
                        c.setUserName(user.getUserName());
                        c.setName(user.getName());
                        c.setAddress(user.getAddress());
                        c.setPhoneNumber(user.getPhoneNumber());
                    }
                });

        return Userlist
                .stream()
                .filter(c -> c.getUserId() == userId)
                .findFirst()
                .get();
    }

    public void deleteUser(int userId){
        Userlist
                .stream()
                .forEach(c -> {
                    if (c.getUserId() == userId) {
                        Userlist.remove(c);
                    }
                });
    }
}