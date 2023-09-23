package com.krecik.randomKillerGenerator.repository;

import com.krecik.randomKillerGenerator.model.Maps;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapsRepository extends CrudRepository<Maps, Integer> {
}
