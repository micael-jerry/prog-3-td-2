package com.footballclub.prog3td2.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Builder
@Getter
@Setter
public class PlayAgainDto {
    private Integer id;
    private Integer team1_score;
    private Integer team2_score;
    private List<GoalDto> goals;
    private TeamDto team1;
    private TeamDto team2;
    private Instant datetime;
}
