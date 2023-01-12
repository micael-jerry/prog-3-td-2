package com.footballclub.prog3td2.controller;

import com.footballclub.prog3td2.Service.PlayAgainService;
import com.footballclub.prog3td2.controller.dto.PlayAgainDto;
import com.footballclub.prog3td2.controller.mapper.PlayAgainMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/play_against")
public class PlayAgainController {
    private PlayAgainService playAgainService;
    private PlayAgainMapper playAgainMapper;

    @GetMapping
    public List<PlayAgainDto> getAllPlayAgainst() {
        return playAgainService.getAll().stream().map(playAgainMapper::toRest).toList();
    }

    @GetMapping(value = "/{id}")
    public PlayAgainDto getPlayAgainstById(@PathVariable Integer id) {
        return playAgainMapper.toRest(
                playAgainService.getById(id)
        );
    }

    @GetMapping(value = "/teams/{teamId}")
    public List<PlayAgainDto> getAllByTeam(@PathVariable Integer teamId) {
        return playAgainService.getAllByTeamId(teamId).stream().map(playAgainMapper::toRest).toList();
    }
}
