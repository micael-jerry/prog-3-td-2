package com.footballclub.prog3td2.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Builder
@Getter
@Setter
public class PlayAgainDto {
    private Integer id;
    private TeamDto team1;
    private TeamDto team2;
    private Instant datetime;
}
