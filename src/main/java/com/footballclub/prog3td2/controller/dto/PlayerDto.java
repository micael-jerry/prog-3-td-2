package com.footballclub.prog3td2.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PlayerDto {
    private Integer id;
    private String name;
    private boolean is_guardian;
}
