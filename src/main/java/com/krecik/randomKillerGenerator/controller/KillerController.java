package com.krecik.randomKillerGenerator.controller;

import com.krecik.randomKillerGenerator.model.Killer;
import com.krecik.randomKillerGenerator.repository.KillerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KillerController {

    private KillerRepository killerRepository;

    //http://localhost:8080/h2-console@GetMapping("/killer")
    /*
    public String getKiller(){
        assert killerService != null;
        return killerService.getSingleKiller(1).getName();
    }
     */

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Killer> getAllKillers(){
        return killerRepository.findAll();
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
