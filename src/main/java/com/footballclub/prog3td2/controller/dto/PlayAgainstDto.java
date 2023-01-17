package com.footballclub.prog3td2.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Builder
@Getter
@Setter
public class PlayAgainstDto {
    private Integer id;
    private Integer team_1_score;
    private Integer team_2_score;
    private List<GoalDto> team_1_goals;
    private List<GoalDto> team_2_goals;
    private TeamDto team_1;
    private TeamDto team_2;
    private Instant datetime;
}
