package com.example.prakt2.controllers;

import com.example.prakt2.models.Doljnost;
import com.example.prakt2.models.Filial;
import com.example.prakt2.models.Worker;
import com.example.prakt2.repos.DoljnostRepository;
import com.example.prakt2.repos.FilialRepository;
import com.example.prakt2.repos.WorkerRepository;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/workers")
public class WorkerController {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private DoljnostRepository doljRepository;

    @GetMapping("/worker")
    private String Main(Model model){
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers", workers);
        Iterable<Filial> filials = filialRepository.findAll();
        model.addAttribute("filials", filials);

        return "workers/worker";
    }

    @PostMapping("/worker/add")
    public String blogPostAdd(@RequestParam String worker, @RequestParam String filial, Model model)
    {
        Worker workerMod = workerRepository.findByName(worker);
        Filial filialMod = filialRepository.findByName(filial);
        workerMod.getFilials().add(filialMod);
        filialMod.getWorkers().add(workerMod);
        workerRepository.save(workerMod);
        filialRepository.save(filialMod);
        return "redirect:/workers/worker";
    }
    @GetMapping("/index")
    String index() {
        return "workers/index";
    }

    @GetMapping("/doljnost")
    private String Dolj(Model model){
        Iterable<Doljnost> doljnost = doljRepository.findAll();
        model.addAttribute("popit", doljnost);
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers", workers);

        return "workers/doljnost";
    }

    @PostMapping("/doljnost/add")
    public String doljAdd(@RequestParam String worker, @RequestParam String doljnost, Model model)
    {
        Worker workerMod = workerRepository.findByName(worker);
        Doljnost doljnostMod = doljRepository.findByName(doljnost);
        workerMod.setDoljnost(doljnostMod);
        workerRepository.save(workerMod);
        return "redirect:/workers/doljnost";
    }

}
