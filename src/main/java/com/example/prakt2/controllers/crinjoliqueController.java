package com.example.prakt2.controllers;

import com.example.prakt2.models.crinjolique;
import com.example.prakt2.models.flexik;
import com.example.prakt2.repos.crinjolique_repo;
import com.example.prakt2.repos.flexik_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/crinjolique")
public class crinjoliqueController {




        @Autowired
        private crinjolique_repo crinjRepo;

        @GetMapping("/index")
        String index() {
            return "crinjolique/crinjolique";
        }

        @GetMapping("/add")
        String addFlexique() {
            return "crinjolique/add";
        }

        @GetMapping("/check")
        String checkFlex(Model model) {
            var flexiki = crinjRepo.findAll();

            model.addAttribute("flexiki", flexiki);
            return "crinjolique/checkcringe";
        }

        @GetMapping("/search")
        String searchFlex(Model model, @RequestParam(value = "searcher", required = false) String text) {
            var crinjoliques = crinjRepo.findByEsheodnoPoleContains(text);
            model.
                    addAttribute("flexiki", crinjoliques);
            return "crinjolique/checkcringe";
        }

        @PostMapping("/save")
        String createFlex(@RequestParam(value = "title", required = false) String title,
                          @RequestParam(value = "sub", required = false) String sub,
                          @RequestParam(value = "type", required = false) String type,
                          @RequestParam(value = "aboba", required = false) String aboba,
                          @RequestParam(value = "flexStatus", required = false) String flexedtitle,
                          Model model) {

            crinjolique newFlex = new crinjolique(title, sub, type, aboba, flexedtitle);

            crinjRepo.save(newFlex);
            return "crinjolique/crinjolique";

        }




    }


