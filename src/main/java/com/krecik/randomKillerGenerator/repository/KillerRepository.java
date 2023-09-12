package com.krecik.randomKillerGenerator.repository;

import com.krecik.randomKillerGenerator.model.Killers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KillerRepository extends CrudRepository<Killers, Integer> {
}
