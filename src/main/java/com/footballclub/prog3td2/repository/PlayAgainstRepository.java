package com.footballclub.prog3td2.repository;

import com.footballclub.prog3td2.model.PlayAgainst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayAgainstRepository extends JpaRepository<PlayAgainst, Integer> {
    List<PlayAgainst> findAllByTeam1_IdOrTeam2_Id(Integer team1_id, Integer team2_id);

    PlayAgainst findByTeam1_IdOrTeam2_IdAndId(Integer team1_id, Integer team2_id, Integer id);
}
