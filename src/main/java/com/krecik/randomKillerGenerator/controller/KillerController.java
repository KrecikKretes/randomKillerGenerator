package com.krecik.randomKillerGenerator.controller;

import com.krecik.randomKillerGenerator.model.Killers;
import com.krecik.randomKillerGenerator.repository.KillerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import java.util.Optional;

@Controller
public class KillerController {

    private final KillerRepository killerRepository;

    public KillerController(KillerRepository killerRepository) {
        this.killerRepository = killerRepository;
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/killer")
    public @ResponseBody Iterable<Killers> getAllKillers(){
        return killerRepository.findAll();
    }

    @RequestMapping("/killers")
    public @ResponseBody Optional<Killers> getOneKiller(){
        Random rand = new Random();
        int n = rand.nextInt((int) killerRepository.count());
        return killerRepository.findById(++n);
    }

    @RequestMapping("/name")
    public @ResponseBody String getOneKillerName(){
        Random rand = new Random();
        int n = rand.nextInt((int) killerRepository.count());
        return killerRepository.findById(++n).get().getName();
    }
}
