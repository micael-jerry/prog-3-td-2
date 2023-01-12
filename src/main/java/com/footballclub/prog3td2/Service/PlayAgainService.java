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
        return playAgainRepository.findAll()
                .stream().map(this::updateInfo)
                .toList();
    }

    public PlayAgain getById(Integer id) {
        return this.updateInfo(
                playAgainRepository.getReferenceById(id)
        );
    }

    public List<PlayAgain> getAllByTeamId(Integer id) {
        return playAgainRepository.findAllByTeam1_IdOrTeam2_Id(id, id)
                .stream().map(this::updateInfo)
                .toList();
    }

    public PlayAgain updateInfo(PlayAgain playAgain) {
        playAgain.getGoals().forEach(goal -> {
            if (playAgain.getTeam1().getPlayers().contains(goal.getPlayer())) {
                playAgain.setTeam1_score(playAgain.getTeam1_score() + 1);
            } else if (playAgain.getTeam2().getPlayers().contains(goal.getPlayer())) {
                playAgain.setTeam2_score(playAgain.getTeam2_score() + 1);
            }
        });
        return playAgain;
    }
}
