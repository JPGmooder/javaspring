package com.example.prakt2.controllers;

import com.example.prakt2.models.crinjolique;
import com.example.prakt2.models.flexik;
import com.example.prakt2.repos.crinjolique_repo;
import com.example.prakt2.repos.flexik_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

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


    @GetMapping("/{id}")
    public String read (@PathVariable("id") Long id, Model model) {
        Optional<crinjolique> cringe = crinjRepo.findById(id);
        ArrayList<crinjolique> arrayList = new ArrayList<>();
        cringe.ifPresent(arrayList::add);
        model.addAttribute("flexiki", arrayList);
        return "crinjolique/single";
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable("id") Long id, Model model) {
        crinjRepo.deleteById(id);
        return "redirect:/crinjolique/check";
    }

    @GetMapping("/edit/{id}")
    public String edit (@PathVariable("id") Long id,
                        Model model) {
        if (!crinjRepo.existsById(id)) {
            return "redirect:/crinjolique/check";
        }
        Optional<crinjolique> crinjolique = crinjRepo.findById(id);
        ArrayList<crinjolique> arrayList = new ArrayList<>();
        crinjolique.ifPresent(arrayList::add);
        model.addAttribute("crinjolique", arrayList);
        return "crinjolique/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit (@PathVariable("id") Long id,
                        @RequestParam("title") String title,
                        @RequestParam("sub") String sub,
                        @RequestParam("type") String type,
                        @RequestParam("aboba") String aboba,
                        @RequestParam("flexStatus") String status,
                        Model model) {
        crinjolique crinj = crinjRepo.findById(id).orElseThrow();
        var cringe = new crinjolique(title, sub, type, aboba, status);
        crinj.setIsCringe(title);
        crinj.setCrinjeModifier(sub);
        crinj.setCrinjeCount(aboba);
        crinj.setEshePole(type);
        crinj.setEsheodnoPole(status);

        crinjRepo.save(crinj);
        return "redirect:/crinjolique/check";
    }



    }


