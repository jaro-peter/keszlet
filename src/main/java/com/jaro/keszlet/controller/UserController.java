package com.jaro.keszlet.controller;

import com.jaro.keszlet.model.User;
import com.jaro.keszlet.model.UserDto;
import com.jaro.keszlet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    public String createUser(UserDto userDto, BindingResult result, Model model) {
        User user = new User();
        user.setNev(userDto.getNev());
        user.setEmail(userDto.getEmail());
        user.setJelszo(userDto.getJelszo());
        userRepository.save(user);
        return "redirect:/users";
    }



    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user-list";
    }
}
