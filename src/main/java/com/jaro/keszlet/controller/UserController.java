package com.jaro.keszlet.controller;

import com.jaro.keszlet.model.User;
import com.jaro.keszlet.model.UserDto;
import com.jaro.keszlet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public String createUser(UserDto userDto, BindingResult result, Model model) {
        User user = new User();
        user.setNev(userDto.getNev());
        user.setEmail(userDto.getEmail());
        user.setJelszo(userDto.getJelszo());
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "user-list";
    }

    @GetMapping("/registration")
    public String showAddUser(User user) {
        return "registration";
    }
}
