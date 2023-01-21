package com.footballclub.prog3td2.Service;

import com.footballclub.prog3td2.model.Goal;
import com.footballclub.prog3td2.model.PlayAgainst;
import com.footballclub.prog3td2.repository.PlayAgainstRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PlayAgainstService {
    private PlayAgainstRepository playAgainstRepository;

    public List<PlayAgainst> getAll() {
        return playAgainstRepository.findAll()
                .stream().map(this::updateInfo)
                .toList();
    }

    public PlayAgainst getById(Integer id) {
        return this.updateInfo(
                playAgainstRepository.getReferenceById(id)
        );
    }

    public PlayAgainst getByTeamIdAndId(Integer teamId, Integer id) {
        return this.updateInfo(
                playAgainstRepository.findByTeam1_IdOrTeam2_IdAndId(teamId, teamId, id)
        );
    }

    public List<PlayAgainst> getAllByTeamId(Integer id) {
        return playAgainstRepository.findAllByTeam1_IdOrTeam2_Id(id, id)
                .stream().map(this::updateInfo)
                .toList();
    }

    public PlayAgainst updateInfo(PlayAgainst playAgainst) {
        return this.info(playAgainst);
    }

    public PlayAgainst info(PlayAgainst playAgainst) {
        List<Goal> goalList1 = new ArrayList<>();
        List<Goal> goalList2 = new ArrayList<>();
        playAgainst.getGoals().forEach(goal -> {
//          Check if the player who scored belongs to team 1
            if (playAgainst.getTeam1().getPlayers().contains(goal.getPlayer())) {
//              If the goal is not in his own camp, increase the score of team 1
                if (!goal.isOwnGoal()) {
                    playAgainst.setTeam1_score(playAgainst.getTeam1_score() + 1);
                    goalList1.add(goal);
//              If not, award the goal to the opponent
                } else {
                    playAgainst.setTeam2_score(playAgainst.getTeam2_score() + 1);
                    goalList2.add(goal);
                }
//          Check if the player who scored belongs to team 2
            } else if (playAgainst.getTeam2().getPlayers().contains(goal.getPlayer())) {
//              If the goal is not in his own camp, increase the score of team 2
                if (!goal.isOwnGoal()) {
                    playAgainst.setTeam2_score(playAgainst.getTeam2_score() + 1);
                    goalList2.add(goal);
//              If not, award the goal to the opponent
                } else {
                    playAgainst.setTeam1_score(playAgainst.getTeam1_score() + 1);
                    goalList1.add(goal);
                }
            }
        });
        playAgainst.setTeam1_goals(goalList1);
        playAgainst.setTeam2_goals(goalList2);
        return playAgainst;
    }
}
