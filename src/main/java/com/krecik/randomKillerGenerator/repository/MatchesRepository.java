package com.krecik.randomKillerGenerator.repository;

import com.krecik.randomKillerGenerator.model.Matches;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchesRepository extends CrudRepository<Matches,Integer> {
}
