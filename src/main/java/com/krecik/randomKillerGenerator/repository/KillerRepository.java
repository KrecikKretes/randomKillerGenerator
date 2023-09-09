package com.krecik.randomKillerGenerator.repository;

import com.krecik.randomKillerGenerator.model.Killer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KillerRepository extends CrudRepository<Killer, Integer> {
}
