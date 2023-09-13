package com.krecik.randomKillerGenerator.controller;

import com.krecik.randomKillerGenerator.model.Killers;
import com.krecik.randomKillerGenerator.repository.KillerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class KillerController {

    private final KillerRepository killerRepository;
    private List<Integer> numbers = new ArrayList<>();

    public KillerController(KillerRepository killerRepository) {
        this.killerRepository = killerRepository;
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/home")
    public String home(){
        numbers.clear();
        return "home";
    }

    @RequestMapping("/number")
    public @ResponseBody String number(){
        StringBuilder a = new StringBuilder();
        for(Integer n: numbers){
            a.append(n);
        }
        return a.toString();
    }

    @RequestMapping("/killers")
    public @ResponseBody Iterable<Killers> getAllKillers(){
        return killerRepository.findAll();
    }

    @RequestMapping("/killer")
    public @ResponseBody Optional<Killers> getOneKiller(){
        Random rand = new Random();
        int n = rand.nextInt((int) killerRepository.count());
        return killerRepository.findById(++n);
    }

    @RequestMapping("/name")
    public @ResponseBody String getOneKillerName(){
        int n;
        do {
            Random rand = new Random();
            n = rand.nextInt((int) killerRepository.count());
        }while(numbers.contains(n) && !numbers.isEmpty());
        numbers.add(n);

        return killerRepository.findById(++n).get().getName();
    }
}
