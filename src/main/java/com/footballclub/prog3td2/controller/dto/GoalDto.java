package com.footballclub.prog3td2.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GoalDto {
    private Integer id;
    private Integer playAgainId;
    private Integer playerId;
    private Integer time;
    private boolean isOnGoal;
}
