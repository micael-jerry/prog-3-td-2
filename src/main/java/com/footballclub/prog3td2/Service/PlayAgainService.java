package com.footballclub.prog3td2.Service;

import com.footballclub.prog3td2.model.PlayAgain;
import com.footballclub.prog3td2.repository.PlayAgainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayAgainService {
    private PlayAgainRepository playAgainRepository;

    public List<PlayAgain> getAll() {
        return playAgainRepository.findAll();
    }

    public List<PlayAgain> getAllByTeamId(Integer id) {
        return playAgainRepository.findAllByTeam1_IdOrTeam2_Id(id,id);
    }
}
