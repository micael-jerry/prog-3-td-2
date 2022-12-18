package com.footballclub.prog3td2.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class TeamDto {
    private Integer id;
    private String name;
    private List<PlayerDto> players;
    private List<SponsorDto> sponsors;
}
