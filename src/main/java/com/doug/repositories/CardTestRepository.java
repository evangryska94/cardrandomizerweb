package com.doug.repositories;

import com.doug.domain.CardTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by doug on 3/5/17.
 */
@Repository
public interface CardTestRepository extends JpaRepository<CardTest, Integer> {
}
