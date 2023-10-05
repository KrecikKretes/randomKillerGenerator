package com.krecik.randomKillerGenerator.service;

import com.krecik.randomKillerGenerator.model.Matches;
import com.krecik.randomKillerGenerator.repository.MatchesRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CSVExportService {
    private final MatchesRepository matchesRepository;

    public CSVExportService(MatchesRepository matchesRepository) {
        this.matchesRepository = matchesRepository;
    }

    public List<Matches> findAllMatches(){
        return (List<Matches>) matchesRepository.findAll();
    }

}

