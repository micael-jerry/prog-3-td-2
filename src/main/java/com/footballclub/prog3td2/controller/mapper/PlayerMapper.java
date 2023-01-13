package com.footballclub.prog3td2.controller.mapper;

import com.footballclub.prog3td2.controller.dto.PlayerDto;
import com.footballclub.prog3td2.model.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerMapper {
    public PlayerDto toRest(Player player) {
        return PlayerDto.builder()
                .id(player.getId())
                .name(player.getName())
                .is_guardian(player.isGuardian())
                .build();
    }

    public Player toDomain(PlayerDto playerDto) {
        Player player = new Player();
        player.setId(playerDto.getId());
        player.setName(playerDto.getName());
        player.setGuardian(playerDto.is_guardian());
        return player;
    }

    public List<PlayerDto> toRest(List<Player> playerList) {
        return playerList.stream().map(this::toRest).toList();
    }

    public List<Player> toDomain(List<PlayerDto> playerDtoList) {
        return playerDtoList.stream().map(this::toDomain).toList();
    }
}
