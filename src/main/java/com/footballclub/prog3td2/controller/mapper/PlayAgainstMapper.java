package com.footballclub.prog3td2.controller.mapper;

import com.footballclub.prog3td2.controller.dto.PlayAgainstDto;
import com.footballclub.prog3td2.model.PlayAgainst;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayAgainstMapper {
    private TeamMapper teamMapper;
    private GoalMapper goalMapper;

    public PlayAgainstDto toRest(PlayAgainst playAgainst) {
        return PlayAgainstDto.builder()
                .id(playAgainst.getId())
                .datetime(playAgainst.getDatetime())
                .team_1(playAgainst.getTeam1() != null ? teamMapper.toRest(playAgainst.getTeam1()) : null)
                .team_2(playAgainst.getTeam2() != null ? teamMapper.toRest(playAgainst.getTeam2()) : null)
                .team_1_goals(
                        playAgainst.getTeam1_goals()
                                .stream().map(goalMapper::toRest)
                                .toList()
                )
                .team_2_goals(
                        playAgainst.getTeam2_goals()
                                .stream().map(goalMapper::toRest)
                                .toList()
                )
                .team_1_score(playAgainst.getTeam1_score())
                .team_2_score(playAgainst.getTeam2_score())
                .build();
    }

    public PlayAgainst toDomain(PlayAgainstDto playAgainstDto) {
        PlayAgainst playAgainst = new PlayAgainst();
        playAgainst.setId(playAgainstDto.getId());
        playAgainst.setDatetime(playAgainstDto.getDatetime());
        playAgainst.setTeam1(playAgainstDto.getTeam_1() != null ? teamMapper.toDomain(playAgainstDto.getTeam_1()) : null);
        playAgainst.setTeam2(playAgainstDto.getTeam_2() != null ? teamMapper.toDomain(playAgainstDto.getTeam_2()) : null);
        return playAgainst;
    }
}
