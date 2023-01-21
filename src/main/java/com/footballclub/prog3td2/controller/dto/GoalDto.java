package com.footballclub.prog3td2.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GoalDto {
    private Integer id;
    private Integer play_against_id;
    private Integer player_id;
    private Integer time;
    private boolean is_own_goal;
}
