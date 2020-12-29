package com.probal.userapp.service;

import com.probal.userapp.model.Role;
import com.probal.userapp.model.User;
import com.probal.userapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<String> validateUser(String userName, String password){
        List<String> userRoles = new ArrayList<>();
        User user = null;
        try {
            user = userRepository.getUserByUsername(userName);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "User not found");
        }
        if(user != null) {
            if(user.getUsername().equals(userName) && user.getPassword().equals(password)){
                Set<Role> roles = user.getRoles();
                for (Role role : roles) {
                    userRoles.add(role.getName());
                }
                return userRoles;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public void saveUser(String fullname, String username, String password) {
        User user = new User(fullname, username, password);
        userRepository.save(user);
    }



}
