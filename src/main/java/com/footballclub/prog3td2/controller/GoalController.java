package com.footballclub.prog3td2.controller;

import com.footballclub.prog3td2.Service.GoalService;
import com.footballclub.prog3td2.controller.dto.GoalDto;
import com.footballclub.prog3td2.controller.mapper.GoalMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/goals")
public class GoalController {
    private GoalService goalService;
    private GoalMapper goalMapper;

    @GetMapping
    public List<GoalDto> findAllGoals() {
        return goalService.findAll()
                .stream().map(goalMapper::toRest)
                .toList();
    }

    @GetMapping(value = "/{id}")
    public GoalDto findGoalById(@PathVariable(name = "id") Integer id) {
        return goalMapper.toRest(goalService.findById(id));
    }
}
