package com.probal.userapp.controller;

import com.probal.userapp.model.User;
import com.probal.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String home() { return "home"; }

    @RequestMapping("/register")
    public String register() {
        return "registration";
    }



    @GetMapping("/login")
    public String loginController() {
        return "login";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Object showUser(HttpServletRequest request){
        return "user";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public Object showAdmin(HttpServletRequest request){
        return "admin";
    }

    @PostMapping("/login_user")
    public String loginHomePage(@RequestParam("userName") String userName,
                                @RequestParam("userPassword") String userPassword,
                                Model model,
                                HttpSession session, HttpServletRequest request) {
        List<String> validUser = userService.validateUser(userName, userPassword);

        if(validUser.isEmpty()){
            return "login";
        }


        session.setAttribute("user_role",validUser);
        System.out.println("From controller --> " + session.getId());
        System.out.println("From controller --> " + session.getAttribute("user_role"));
        return "home";
    }

    @RequestMapping("/save_user")
    public String registerUser(@RequestParam String fullName, @RequestParam String userName,
                               @RequestParam String userPassword,
                               @RequestParam String userPasswordRepeat) {
        if(!fullName.isEmpty() && !userName.isEmpty() && !userPassword.isEmpty() && !userPasswordRepeat.isEmpty()) {
            if(userPassword.equals(userPasswordRepeat)) {
                userService.saveUser(fullName, userName, userPassword);
                System.out.println("Registration completed");
                return "login";
            } else {
                System.out.println("Password dont Match");
                return "registration";
            }
        } else {
            System.out.println("Fields can't be empty");
            return "registration";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        session = request.getSession(false);
        return "login";
    }
}

