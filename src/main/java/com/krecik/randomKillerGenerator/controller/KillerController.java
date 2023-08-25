package com.krecik.randomKillerGenerator.controller;

import com.krecik.randomKillerGenerator.service.KillerService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class KillerController {

    private final KillerService killerService;


    @GetMapping("/killer")
    public String getKiller(){


        return killerService.getSingleKiller(1).getName();
    }

    @GetMapping("/")
    public String getTest(){
        return ".....";
    }
}
