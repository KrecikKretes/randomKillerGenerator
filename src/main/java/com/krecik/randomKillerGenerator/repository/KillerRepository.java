package com.krecik.randomKillerGenerator.repository;

import com.krecik.randomKillerGenerator.model.Killer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KillerRepository extends JpaRepository<Killer, Long> {

    List<Killer> findAllByName(String name);

}
