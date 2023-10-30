package com.example.onlinemarketplace.controllers;


import com.example.onlinemarketplace.models.User;
import com.example.onlinemarketplace.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class UserController {


    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model){
        if(!userService.createUser(user)){
            model.addAttribute("errorMessage", "User with this email already exist");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
