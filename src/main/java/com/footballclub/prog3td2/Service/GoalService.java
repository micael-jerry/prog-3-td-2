package com.footballclub.prog3td2.Service;

import com.footballclub.prog3td2.model.Goal;
import com.footballclub.prog3td2.repository.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GoalService {
    private GoalRepository goalRepository;

    public List<Goal> findAll() {
        return goalRepository.findAll();
    }

    public List<Goal> findAllByPlayAgainst(Integer playAgainstId) {
        return goalRepository.findAllByPlayAgain_Id(playAgainstId);
    }

    public Goal findById(Integer id) {
        return goalRepository.findById(id).get();
    }

    public List<Goal> findAllByPlayerId(Integer playerId) {
        return goalRepository.findAllByPlayer_Id(playerId);
    }
}
