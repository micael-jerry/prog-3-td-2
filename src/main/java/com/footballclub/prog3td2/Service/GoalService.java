package com.footballclub.prog3td2.Service;

import com.footballclub.prog3td2.controller.exception.BadRequestException;
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
        List<Goal> goalList = goalRepository.findAllByPlayAgainst_Id(playAgainstId);
        if (goalList != null) {
            return goalList;
        }
        throw new BadRequestException("play against Id: " + playAgainstId + " not exist");
    }

    public Goal findById(Integer id) {
        return goalRepository.getReferenceById(id);
    }

    public List<Goal> findAllByPlayerId(Integer playerId) {
        return goalRepository.findAllByPlayer_Id(playerId);
    }
}
