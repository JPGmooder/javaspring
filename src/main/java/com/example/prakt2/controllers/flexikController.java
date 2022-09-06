package com.example.prakt2.controllers;

import com.example.prakt2.models.flexik;
import com.example.prakt2.repos.flexik_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/flexiki")
public class flexikController {

    @Autowired
    private flexik_repo flexikRepo;

    @GetMapping("/index")
    String index() {
        return "flexi/flexik";
    }

    @GetMapping("/add")
    String addFlexique() {
        return "flexi/add";
    }

    @GetMapping("/check")
    String checkFlex(Model model) {
        var flexiki = flexikRepo.findAll();

        model.addAttribute("flexiki", flexiki);
        return "/flexi/checkflex";
    }

    @GetMapping("/search")
    String searchFlex(Model model, @RequestParam(value = "searcher", required = false) String text) {
        var flexers = flexikRepo.findByFlexTitle(text);
        model.addAttribute("flexiki", flexers);
        return "/flexi/checkflex";
    }

    @PostMapping("/save")
    String createFlex(@RequestParam(value = "title", required = false) String title,
                    @RequestParam(value = "sub", required = false) String sub,
                    @RequestParam(value = "type", required = false) String type,
                    @RequestParam(value = "aboba", required = false) String aboba,
                    @RequestParam(value = "flexStatus", required = false) String flexedtitle,
                    Model model) {

        flexik newFlex = new flexik(title, sub, type, aboba, flexedtitle);

        flexikRepo.save(newFlex);
        return "flexi/flexik";

    }




}
