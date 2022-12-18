package com.footballclub.prog3td2.Service;

import com.footballclub.prog3td2.model.Player;
import com.footballclub.prog3td2.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {
    private PlayerRepository playerRepository;

    public List<Player> getAll() {
        return playerRepository.findAll(Sort.by(Sort.Direction.ASC,"number"));
    }
}
