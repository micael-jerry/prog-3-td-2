package com.footballclub.prog3td2.repository;

import com.footballclub.prog3td2.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {
    List<Goal> findAllByPlayAgainst_Id(Integer playAgainstId);
    List<Goal> findAllByPlayer_Id(Integer playerId);
}
