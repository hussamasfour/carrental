package com.hussam.carrental.controllers;

import com.hussam.carrental.entities.User;
import com.hussam.carrental.services.SecurityService;
import com.hussam.carrental.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SecurityService securityService;

    @RequestMapping("/showRegister")
    public ModelAndView showUserRegister(ModelAndView modelAndView, User user){
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registerUser");
        return modelAndView;
    }
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, @Valid @ModelAttribute("user") User user, Errors errors){

        if(errors.hasErrors()){
            modelAndView.setViewName("registerUser");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/showLogin")
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, BindingResult bindingResult){
        boolean loginResponse = securityService.login(email,password);
        if(bindingResult.hasErrors()){

        }
        if(loginResponse ){
            return "searchForCar";
        }
        return "login";
    }


}
