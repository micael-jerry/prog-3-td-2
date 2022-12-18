package com.footballclub.prog3td2.controller.mapper;

import com.footballclub.prog3td2.controller.dto.TeamDto;
import com.footballclub.prog3td2.model.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TeamMapper {
    private PlayerMapper playerMapper;
    private SponsorMapper sponsorMapper;
    public TeamDto toRest(Team team) {
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .players(team.getPlayers() != null ? playerMapper.toRest(team.getPlayers()) : null)
                .sponsors(team.getSponsors() != null ? sponsorMapper.toRest(team.getSponsors()) : null)
                .build();
    }

    public Team toDomain(TeamDto teamDto) {
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setName(team.getName());
        team.setPlayers(teamDto.getPlayers() != null ? playerMapper.toDomain(teamDto.getPlayers()) : null);
        team.setSponsors(teamDto.getSponsors() != null ? sponsorMapper.toDomain(teamDto.getSponsors()) : null);
        return team;
    }
}
