package com.doug.repositories;

import com.doug.domain.ScoreList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Doug on 9/10/16.
 */
public interface ScoreRepository extends JpaRepository<ScoreList, Integer> {

//	ScoreList findOne(String id);

//	List<Person> findByAgeGreaterThan(int age);
//
//	List<Person> findByAgeGreaterThanOrderByNameAsc(int age);
//
//	List<Person> findByAgeGreaterThanOrAgeLessThan(int over, int under);
}
