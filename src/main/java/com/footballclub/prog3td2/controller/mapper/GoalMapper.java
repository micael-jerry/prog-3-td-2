package com.footballclub.prog3td2.controller.mapper;

import com.footballclub.prog3td2.controller.dto.GoalDto;
import com.footballclub.prog3td2.model.Goal;
import com.footballclub.prog3td2.repository.PlayAgainRepository;
import com.footballclub.prog3td2.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GoalMapper {
    private PlayAgainRepository playAgainRepository;
    private PlayerRepository playerRepository;

    public GoalDto toRest(Goal goal) {
        return GoalDto.builder()
                .id(goal.getId())
                .playAgainId(goal.getPlayAgain().getId())
                .playerId(goal.getPlayer().getId())
                .time(goal.getTime())
                .isOnGoal(goal.isOnGoal())
                .build();
    }

    public Goal toDomain(GoalDto goalDto) {
        Goal goal = new Goal();
        goal.setId(goalDto.getId());
        goal.setPlayAgain(playAgainRepository.getReferenceById(goalDto.getPlayAgainId()));
        goal.setPlayer(playerRepository.getReferenceById(goalDto.getPlayerId()));
        goal.setTime(goalDto.getTime());
        goal.setOnGoal(goalDto.isOnGoal());
        return goal;
    }
}
