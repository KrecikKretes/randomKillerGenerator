package com.krecik.randomKillerGenerator.repository;

import com.krecik.randomKillerGenerator.model.Teams;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository  extends CrudRepository<Teams, Integer> {
}
