package com.codegym.controller;


import com.codegym.model.User;
import com.codegym.services.IUserService;
import com.codegym.validator.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @ModelAttribute("users")
    public Iterable<User> showAll()
    {
        return userService.findAll();
    }

    @GetMapping("/register")
    public String showForm(Model model)
    {
        model.addAttribute("newUser",new User());
        return "/register";
    }

    @PostMapping("/register")
    public ModelAndView saveUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult bindingResult)
    {
        new PhoneNumberValidator().validate(newUser,bindingResult);
        ModelAndView modelAndView ;
        if(bindingResult.hasErrors())
        {
            modelAndView = new ModelAndView("/register");
        }
        modelAndView=new ModelAndView("/success");
        userService.save(newUser);
        return modelAndView;
    }



}
