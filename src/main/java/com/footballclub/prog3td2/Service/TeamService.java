package com.footballclub.prog3td2.Service;

import com.footballclub.prog3td2.controller.exception.BadRequestException;
import com.footballclub.prog3td2.model.Team;
import com.footballclub.prog3td2.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {
    private TeamRepository teamRepository;

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Team getById(Integer id) {
        if (teamRepository.existsById(id)) {
            return teamRepository.getReferenceById(id);
        } else {
            throw new BadRequestException("Id: " + id + " not exist");
        }
    }
}
