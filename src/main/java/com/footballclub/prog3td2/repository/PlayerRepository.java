package com.footballclub.prog3td2.repository;

import com.footballclub.prog3td2.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findAllByTeam_Id(Integer teamId);
}
