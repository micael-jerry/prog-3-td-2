package com.footballclub.prog3td2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "goal")
public class Goal implements Serializable {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "play_against_id", nullable = false)
    private PlayAgainst playAgainst;
    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;
    @Column(nullable = false)
    private int time;
    @Column(name = "is_own_goal", nullable = false)
    private boolean isOwnGoal;
}
