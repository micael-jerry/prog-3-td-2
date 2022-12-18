package com.footballclub.prog3td2.controller;

import com.footballclub.prog3td2.Service.PlayerService;
import com.footballclub.prog3td2.controller.dto.PlayerDto;
import com.footballclub.prog3td2.controller.mapper.PlayerMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/players")
public class PlayerController {
    private PlayerMapper playerMapper;
    private PlayerService playerService;

    @GetMapping
    public List<PlayerDto> getAllPlayers() {
        return playerService.getAll().stream().map(playerMapper::toRest).toList();
    }
}
