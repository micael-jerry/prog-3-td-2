package com.footballclub.prog3td2.controller;

import com.footballclub.prog3td2.Service.TeamService;
import com.footballclub.prog3td2.controller.dto.TeamDto;
import com.footballclub.prog3td2.controller.mapper.TeamMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/teams")
public class TeamController {
    private TeamService teamService;
    private TeamMapper teamMapper;

    @GetMapping
    public List<TeamDto> getAllTeam() {
        return teamService.getAll().stream().map(teamMapper::toRest).toList();
    }

    @GetMapping(value = "/{id}")
    public TeamDto getTeamById(@PathVariable Integer id) {
        return teamMapper.toRest(
                teamService.getById(id)
        );
    }
}
