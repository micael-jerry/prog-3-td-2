package com.footballclub.prog3td2.controller;

import com.footballclub.prog3td2.Service.PlayAgainstService;
import com.footballclub.prog3td2.controller.dto.PlayAgainstDto;
import com.footballclub.prog3td2.controller.mapper.PlayAgainstMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlayAgainstController {
    private PlayAgainstService playAgainstService;
    private PlayAgainstMapper playAgainstMapper;

    @GetMapping(value = "/play_against")
    public List<PlayAgainstDto> getAllPlayAgainst() {
        return playAgainstService.getAll().stream().map(playAgainstMapper::toRest).toList();
    }

    @GetMapping(value = "/play_against/{id}")
    public PlayAgainstDto getPlayAgainstById(@PathVariable Integer id) {
        return playAgainstMapper.toRest(
                playAgainstService.getById(id)
        );
    }

    @GetMapping(value = "/teams/{teamId}/play_against")
    public List<PlayAgainstDto> getPlayAgainstByTeam(@PathVariable Integer teamId) {
        return playAgainstService.getAllByTeamId(teamId).stream().map(playAgainstMapper::toRest).toList();
    }

    @GetMapping(value = "/teams/{teamId}/play_against/{id}")
    public PlayAgainstDto getPlayAgainstByTeamIdAndPlayAgainstId(@PathVariable Integer id, @PathVariable Integer teamId) {
        return playAgainstMapper.toRest(
                playAgainstService.getByTeamIdAndId(teamId, id)
        );
    }
}
