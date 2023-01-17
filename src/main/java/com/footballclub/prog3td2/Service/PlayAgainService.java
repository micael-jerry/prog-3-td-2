package com.footballclub.prog3td2.Service;

import com.footballclub.prog3td2.model.Goal;
import com.footballclub.prog3td2.model.PlayAgain;
import com.footballclub.prog3td2.repository.PlayAgainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public PlayAgain getByTeamIdAndId(Integer teamId, Integer id) {
        return this.updateInfo(
                playAgainRepository.findByTeam1_IdOrTeam2_IdAndId(teamId, teamId, id)
        );
    }

    public List<PlayAgain> getAllByTeamId(Integer id) {
        return playAgainRepository.findAllByTeam1_IdOrTeam2_Id(id, id)
                .stream().map(this::updateInfo)
                .toList();
    }

    public PlayAgain updateInfo(PlayAgain playAgain) {
        return this.info(playAgain);
    }

    public PlayAgain info(PlayAgain playAgain) {
        List<Goal> goalList1 = new ArrayList<>();
        List<Goal> goalList2 = new ArrayList<>();
        playAgain.getGoals().forEach(goal -> {
            if (playAgain.getTeam1().getPlayers().contains(goal.getPlayer())) {
                if (goal.isOnGoal()) {
                    playAgain.setTeam1_score(playAgain.getTeam1_score() + 1);
                    goalList1.add(goal);
                } else {
                    playAgain.setTeam2_score(playAgain.getTeam2_score() + 1);
                    goalList2.add(goal);
                }
            } else if (playAgain.getTeam2().getPlayers().contains(goal.getPlayer())) {
                if (goal.isOnGoal()) {
                    playAgain.setTeam2_score(playAgain.getTeam2_score() + 1);
                    goalList2.add(goal);
                } else {
                    playAgain.setTeam1_score(playAgain.getTeam1_score() + 1);
                    goalList1.add(goal);
                }
            }
        });
        playAgain.setTeam1_goals(goalList1);
        playAgain.setTeam2_goals(goalList2);
        return playAgain;
    }
}
