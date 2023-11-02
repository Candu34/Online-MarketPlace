package com.example.onlinemarketplace.controllers;


import com.example.onlinemarketplace.models.User;
import com.example.onlinemarketplace.models.enums.Role;
import com.example.onlinemarketplace.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    private final UserService userService;

    @GetMapping()
    public String admin(Model model){
        model.addAttribute("users", userService.findAll());
        return "admin";
    }

    @PostMapping("/user/ban/{id}")
    public String userBan(@PathVariable("id") Long id){
        userService.banUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/user/edit/{user}")
    public String userEdit(@PathVariable("user") User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user-edit";
    }

    @PostMapping("/user/edit")
    public String userEdit(@RequestParam("uerId") User user, @RequestParam Map<String, String> form){
        userService.changeUserRoles(user, form);
        return "redirect:/admin";
    }


}
