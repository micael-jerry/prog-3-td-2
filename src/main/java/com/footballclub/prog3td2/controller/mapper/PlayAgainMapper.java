package com.footballclub.prog3td2.controller.mapper;

import com.footballclub.prog3td2.controller.dto.PlayAgainDto;
import com.footballclub.prog3td2.model.PlayAgain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayAgainMapper {
    private TeamMapper teamMapper;
    private GoalMapper goalMapper;

    public PlayAgainDto toRest(PlayAgain playAgain) {
        return PlayAgainDto.builder()
                .id(playAgain.getId())
                .datetime(playAgain.getDatetime())
                .team1(playAgain.getTeam1() != null ? teamMapper.toRest(playAgain.getTeam1()) : null)
                .team2(playAgain.getTeam2() != null ? teamMapper.toRest(playAgain.getTeam2()) : null)
                .goals(
                        playAgain.getGoals()
                                .stream().map(goalMapper::toRest)
                                .toList()
                )
                .team1_score(playAgain.getTeam1_score())
                .team2_score(playAgain.getTeam2_score())
                .build();
    }

    public PlayAgain toDomain(PlayAgainDto playAgainDto) {
        PlayAgain playAgain = new PlayAgain();
        playAgain.setId(playAgainDto.getId());
        playAgain.setDatetime(playAgainDto.getDatetime());
        playAgain.setTeam1(playAgainDto.getTeam1() != null ? teamMapper.toDomain(playAgainDto.getTeam1()) : null);
        playAgain.setTeam2(playAgainDto.getTeam2() != null ? teamMapper.toDomain(playAgainDto.getTeam2()) : null);
        return playAgain;
    }
}
