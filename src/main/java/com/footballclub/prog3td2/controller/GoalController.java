package com.footballclub.prog3td2.controller;

import com.footballclub.prog3td2.Service.GoalService;
import com.footballclub.prog3td2.controller.dto.GoalDto;
import com.footballclub.prog3td2.controller.mapper.GoalMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GoalController {
    private GoalService goalService;
    private GoalMapper goalMapper;

    @GetMapping(value = "/goals")
    public List<GoalDto> getAllGoals() {
        return goalService.findAll()
                .stream().map(goalMapper::toRest)
                .toList();
    }

    @GetMapping(value = "/goals/{id}")
    public GoalDto getGoalById(@PathVariable(name = "id") Integer id) {
        return goalMapper.toRest(goalService.findById(id));
    }

    @GetMapping(value = "/play_against/{play_against_id}/goals")
    public List<GoalDto> getGoalByPlayAgainstId(@PathVariable(name = "play_against_id") Integer playAgainstId) {
        return goalService.findAllByPlayAgainst(playAgainstId)
                .stream().map(goalMapper::toRest)
                .toList();
    }
}
