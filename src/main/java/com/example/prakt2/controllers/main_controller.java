package com.example.prakt2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.prakt2.repos.flexik_repo;

@Controller
@RequestMapping("/index")
public class main_controller {
    @Autowired
    private flexik_repo flexRepository;


    @GetMapping("/index")
    String index(Model model) {
      var findedFlexible =  flexRepository.findAll();
      model.addAttribute("index", findedFlexible);
        return "/index";
    }









}
