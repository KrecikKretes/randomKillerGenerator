package com.krecik.randomKillerGenerator.service;

import com.krecik.randomKillerGenerator.model.Killer;
import com.krecik.randomKillerGenerator.repository.KillerRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class KillerService {

    private final KillerRepository killerRepository;

    public Killer getSingleKiller(long id){
        return killerRepository.findById(id)
                .orElseThrow();
    }


}
