package com.footballclub.prog3td2.controller.mapper;

import com.footballclub.prog3td2.controller.dto.GoalDto;
import com.footballclub.prog3td2.model.Goal;
import com.footballclub.prog3td2.repository.PlayAgainstRepository;
import com.footballclub.prog3td2.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GoalMapper {
    private PlayAgainstRepository playAgainstRepository;
    private PlayerRepository playerRepository;

    public GoalDto toRest(Goal goal) {
        return GoalDto.builder()
                .id(goal.getId())
                .play_against_id(goal.getPlayAgainst().getId())
                .player_id(goal.getPlayer().getId())
                .time(goal.getTime())
                .is_own_goal(goal.isOwnGoal())
                .build();
    }

    public Goal toDomain(GoalDto goalDto) {
        Goal goal = new Goal();
        goal.setId(goalDto.getId());
        goal.setPlayAgainst(playAgainstRepository.getReferenceById(goalDto.getPlay_against_id()));
        goal.setPlayer(playerRepository.getReferenceById(goalDto.getPlayer_id()));
        goal.setTime(goalDto.getTime());
        goal.setOwnGoal(goalDto.is_own_goal());
        return goal;
    }
}
