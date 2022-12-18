package com.footballclub.prog3td2.controller;

import com.footballclub.prog3td2.Service.TeamService;
import com.footballclub.prog3td2.model.Team;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/teams")
public class TeamController {
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeam() {
        return teamService.getAll();
    }
}
