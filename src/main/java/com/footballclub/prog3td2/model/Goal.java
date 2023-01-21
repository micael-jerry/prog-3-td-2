package com.footballclub.prog3td2.model;

import jakarta.persistence.*;
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
    @SequenceGenerator(name = "goal_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goal_seq")
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
