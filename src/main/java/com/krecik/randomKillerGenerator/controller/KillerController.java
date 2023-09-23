package com.krecik.randomKillerGenerator.controller;

import com.krecik.randomKillerGenerator.model.Killers;
import com.krecik.randomKillerGenerator.model.Maps;
import com.krecik.randomKillerGenerator.repository.KillerRepository;
import com.krecik.randomKillerGenerator.repository.MapsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class KillerController {

    private final KillerRepository killerRepository;
    private final MapsRepository mapsRepository;
    private List<Integer> killersID = new ArrayList<>();
    private List<Integer> mapsID = new ArrayList<>();
    private List<Killers> killers = new ArrayList<>();
    private List<Maps> maps = new ArrayList<>();

    public KillerController(KillerRepository killerRepository, MapsRepository mapsRepository) {
        this.killerRepository = killerRepository;
        this.mapsRepository = mapsRepository;
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/home")
    public String home(Model model){
        killersID.clear();
        killers.clear();
        mapsID.clear();
        maps.clear();
        Random rand = new Random();
        int n;
        for(int i = 0; i < 5; i++){
            do {
                n = rand.nextInt((int) killerRepository.count());
            }while(killersID.contains(n) && !killersID.isEmpty());
            killersID.add(n);
            n++;
            killers.add(new Killers(killerRepository.findById(n).get().getId(),
                    killerRepository.findById(n).get().getName(),
                    "/img/killers/" + killerRepository.findById(n).get().getFile()
            ));
        }
        for(int i = 0; i < 2; i++){
            do {
                n = rand.nextInt((int) mapsRepository.count());
            }while(mapsID.contains(n) && !mapsID.isEmpty());
            mapsID.add(n);
            n++;
            maps.add(new Maps(mapsRepository.findById(n).get().getId(),
                    mapsRepository.findById(n).get().getName(),
                    "/img/maps/" + mapsRepository.findById(n).get().getFile()
            ));
            //System.out.println(maps[i].toString());


        }
        model.addAttribute("killers",killers);
        model.addAttribute("maps",maps);
        return "home";
    }


    @RequestMapping("leader")
    public String leader(){
        return "leader";
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
}
