package com.example.prakt2.controllers;

import com.example.prakt2.models.crinjolique;
import com.example.prakt2.models.flexik;
import com.example.prakt2.repos.crinjolique_repo;
import com.example.prakt2.repos.flexik_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/crinjolique")
public class crinjoliqueController {

        @Autowired
        private crinjolique_repo crinjRepo;
    @Autowired
    private flexik_repo flexRepo;

    @GetMapping("/index")
        String index() {
            return "crinjolique/crinjolique";
        }

        @GetMapping("/add")
        String addFlexique(Model model, crinjolique crinjolique) {
            model.addAttribute("flex", flexRepo.findAll());
            model.addAttribute("crinjolique", crinjolique);
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

//        @PostMapping("/save")
//        String createFlex(@RequestParam(value = "title", required = false) String title,
//                          @RequestParam(value = "sub", required = false) String sub,
//                          @RequestParam(value = "type", required = false) String type,
//                          @RequestParam(value = "aboba", required = false) String aboba,
//                          @RequestParam(value = "flexStatus", required = false) String flexedtitle,
//                          Model model) {
//
//            crinjolique newFlex = new crinjolique(title, sub, type, aboba, flexedtitle);
//
//            crinjRepo.save(newFlex);
//            return "crinjolique/crinjolique";
//
//        }

    @PostMapping("/save")
    String createFlex(@ModelAttribute @Valid crinjolique flexiki,
                      @RequestParam(value = "selectilca") String ID,
                      BindingResult bindingResult,
                      Model model) {
        flexiki.setFlex(flexRepo.findById(Long.parseLong(ID)).get());

        if (bindingResult.hasErrors())
        {
            model.addAttribute("crinjolique", flexiki);
            return "crinjolique/add";
        }
        crinjRepo.save(flexiki);
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
        Optional<crinjolique> cringe = crinjRepo.findById(id);
        var flexes = flexRepo.findAll();
        List<flexik> filteredList = new ArrayList<flexik>();
        for (var flex: flexes) {
            if (flex.getId() != cringe.get().flex.getId())
            {
                filteredList.add(flex);
            }
        }
        model.addAttribute("flex", filteredList);
        model.addAttribute("crinjolique", cringe.get());
        return "crinjolique/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit (@PathVariable("id") Long id, @ModelAttribute @Valid crinjolique crinjolique,
                        @RequestParam(value = "selectilca") String ID,
                        BindingResult bindingResult,
                        Model model) {

        if (bindingResult.hasErrors())
        {
            model.addAttribute("crinjolique", crinjolique);
            return "crinjolique/edit";
        }
        crinjolique crinj = crinjRepo.findById(id).orElseThrow();
        crinj.setIsCringe(crinjolique.isCringe);
        crinj.setCrinjeModifier(crinjolique.crinjeModifier);
        crinj.setCrinjeCount(crinjolique.crinjeCount);
        crinj.setEshePole(crinjolique.eshePole);
        crinj.setEsheodnoPole(crinjolique.esheodnoPole);
        crinj.setFlex(flexRepo.findById(Long.parseLong(ID)).get());
        crinjRepo.save(crinj);
        return "redirect:/crinjolique/check";
    }





    }


