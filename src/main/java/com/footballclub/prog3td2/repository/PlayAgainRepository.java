package com.footballclub.prog3td2.repository;

import com.footballclub.prog3td2.model.PlayAgain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayAgainRepository extends JpaRepository<PlayAgain, Integer> {
}
