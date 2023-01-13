package com.footballclub.prog3td2.repository;

import com.footballclub.prog3td2.model.PlayAgain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayAgainRepository extends JpaRepository<PlayAgain, Integer> {
    List<PlayAgain> findAllByTeam1_IdOrTeam2_Id(Integer team1_id, Integer team2_id);

    PlayAgain findByTeam1_IdOrTeam2_IdAndId(Integer team1_id, Integer team2_id, Integer id);
}
