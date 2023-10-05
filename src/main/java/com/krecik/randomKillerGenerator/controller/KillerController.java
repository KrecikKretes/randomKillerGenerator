package com.krecik.randomKillerGenerator.controller;

import com.krecik.randomKillerGenerator.model.*;
import com.krecik.randomKillerGenerator.repository.KillerRepository;
import com.krecik.randomKillerGenerator.repository.MapsRepository;
import com.krecik.randomKillerGenerator.repository.MatchesRepository;
import com.krecik.randomKillerGenerator.repository.TeamsRepository;
import com.krecik.randomKillerGenerator.service.CSVExportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.util.*;

@Controller
public class KillerController {

    private final KillerRepository killerRepository;
    private final MapsRepository mapsRepository;
    private final TeamsRepository teamsRepository;
    private final MatchesRepository matchesRepository;

    private final CSVExportService csvExportService;

    private final List<Integer> killersID = new ArrayList<>();
    private final List<Integer> mapsID = new ArrayList<>();
    private final List<Killers> killers = new ArrayList<>();
    private final List<Maps> maps = new ArrayList<>();
    private final List<Teams> teams = new ArrayList<>();
    private final List<Matches> matches = new ArrayList<>();

    public KillerController(KillerRepository killerRepository,
                            MapsRepository mapsRepository,
                            TeamsRepository teamsRepository,
                            MatchesRepository matchesRepository,
                            CSVExportService csvExportService) {
        this.killerRepository = killerRepository;
        this.mapsRepository = mapsRepository;
        this.teamsRepository = teamsRepository;
        this.matchesRepository = matchesRepository;
        this.csvExportService = csvExportService;
    }

    @GetMapping("/error")
    @ResponseBody
    public String error(){
        return "error";
    }


    @RequestMapping(value= "/{matchId}/saveDraw", method = RequestMethod.POST)
    @ResponseBody
    public String match(@PathVariable("matchId")int matchId, Draw draw){
        Matches matches1 = matchesRepository.findById(matchId).get();
        matches1.setKiller(killerRepository.findById(draw.getIdKiller()).get().getName());
        matches1.setMap(mapsRepository.findById(draw.getIdMap()).get().getName());
        matches1.setAddon(draw.getAddonName());

        matchesRepository.save(matches1);
        return "Work";
    }


    @RequestMapping(value= "/{matchId}/match", method = RequestMethod.PUT)
    public String match(@PathVariable("matchId")int matchId){
        return "match";
    }

    @RequestMapping(value = "/{matchId}/draw",
            method = { RequestMethod.GET, RequestMethod.PUT })
    public String draw(@PathVariable("matchId") int matchId, Model model){
        killersID.clear();
        killers.clear();
        mapsID.clear();
        maps.clear();
        Random rand = new Random();
        System.out.println("------------------"+killerRepository.count());
        int n;
        for(int i = 0; i < 5; i++){
            do {
                n = rand.nextInt((int) killerRepository.count()) + 1;
            }while(killersID.contains(n) && !killersID.isEmpty());
            killersID.add(n);
            killerRepository.findById(n).get().setFile("/img/killers/" +
                    killerRepository.findById(n).get().getFile());
            killers.add(killerRepository.findById(n).get());
        }
        for(int i = 0; i < 2; i++){
            do {
                n = rand.nextInt((int) mapsRepository.count()) + 1;
            }while(mapsID.contains(n) && !mapsID.isEmpty());
            mapsID.add(n);

            mapsRepository.findById(n).get().setFile("/img/maps/" +
                    mapsRepository.findById(n).get().getFile());
            maps.add(mapsRepository.findById(n).get());
        }
        model.addAttribute("killers",killers);
        model.addAttribute("maps",maps);
        model.addAttribute("idMatch", matchId);
        model.addAttribute("draw", new Draw());
        return "draw";
    }


    @RequestMapping("save")
    public String save(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=matches.csv";
        servletResponse.setHeader(headerKey, headerValue);

        List<Matches> matchesList = csvExportService.findAllMatches();

        CsvPreference csvPreference = new CsvPreference.Builder('"', ';', "\r\n").build();
        ICsvBeanWriter csvWriter = new CsvBeanWriter(servletResponse.getWriter(), csvPreference);
        String[] csvHeader = {"ID","Team1","Team2","Result","Killer","Map","Addon","Point1","Point2"};
        String[] nameMapping = {"id","team1","team2","result","killer","map","addon","point1","point2"};

        csvWriter.writeHeader(csvHeader);

        for (Matches matches1 : matchesList) {
            csvWriter.write(matches1, nameMapping);
        }

        csvWriter.close();
        return "save";
    }

    @RequestMapping("leader")
    public String leader(Model model){
        if(teams.isEmpty()){
            for(int i = 1; i <= teamsRepository.count(); i++){
                teams.add(new Teams(teamsRepository.findById(i).get().getId(),
                        teamsRepository.findById(i).get().getName()
                ));
            }
            Collections.shuffle(teams,new Random());
            for(int i = 0; i < teams.size() + 3; i++){
                if(i < teams.size()){
                    matchesRepository.save(new Matches((i+2)/2, teams.get(i).getName(),
                            teams.get(++i).getName()));
                }else{
                    matchesRepository.save(new Matches((i+2)/2,"-","-"));
                }
            }
            for(int i = 1; i <= matchesRepository.count(); i ++){
                matches.add(matchesRepository.findById(i).get());
            }
        }

        model.addAttribute("teams", teams);
        model.addAttribute("matches", matches);
        return "leader";
    }


    @RequestMapping("/killers")
    public @ResponseBody Iterable<Killers> getAllKillers(){
        return killerRepository.findAll();
    }

    @RequestMapping("/matches")
    public @ResponseBody Iterable<Matches> getAllMatches(){
        return matchesRepository.findAll();
    }

    @RequestMapping("/teams")
    public @ResponseBody Iterable<Teams> getAllTeams(){
        return teamsRepository.findAll();
    }

    @RequestMapping("/killer")
    public @ResponseBody Optional<Killers> getOneKiller(){
        Random rand = new Random();
        int n = rand.nextInt((int) killerRepository.count());
        return killerRepository.findById(++n);
    }
}
