package com.example.prakt2.controllers;

import com.example.prakt2.models.Role;
import com.example.prakt2.models.User;
import com.example.prakt2.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String reg_view(Model model)
    {
        return "registration";
    }
    @PostMapping("/registration")
    public String reg_action(User user, Model model)
    {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null)
        {
            model.addAttribute("error", "Такой пользователь уже существует");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ADMIN));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
