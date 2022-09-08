package com.example.prakt2.controllers;

import com.example.prakt2.models.flexik;
import com.example.prakt2.repos.flexik_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

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


    @GetMapping("/{id}")
    public String read (@PathVariable("id") Long id, Model model) {
        Optional<flexik> flexik = flexikRepo.findById(id);
        ArrayList<flexik> arrayList = new ArrayList<>();
        flexik.ifPresent(arrayList::add);
        model.addAttribute("flexiki", arrayList);
        return "flexi/single";
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable("id") Long id, Model model) {
        flexikRepo.deleteById(id);
        return "redirect:/flexiki/check";
    }

    @GetMapping("/edit/{id}")
    public String edit (@PathVariable("id") Long id,
                        Model model) {
        if (!flexikRepo.existsById(id)) {
            return "redirect:/flexiki/check";
        }
        Optional<flexik> flexik = flexikRepo.findById(id);
        ArrayList<flexik> arrayList = new ArrayList<>();
        flexik.ifPresent(arrayList::add);
        model.addAttribute("flexiki", arrayList);
        return "flexi/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit (@PathVariable("id") Long id,
                        @RequestParam("title") String title,
                        @RequestParam("sub") String sub,
                        @RequestParam("type") String type,
                        @RequestParam("aboba") String aboba,
                        @RequestParam("flexStatus") String status,
                        Model model) {

        flexik flexik = flexikRepo.findById(id).orElseThrow();

        flexik.setFlexTitle(title);
        flexik.setFlexSub(sub);
        flexik.setAbobaAmount(aboba);
        flexik.setFlexType(type);
        flexik.setIsFlexing(status);

        flexikRepo.save(flexik);
        return "redirect:/flexiki/check";
    }



}
