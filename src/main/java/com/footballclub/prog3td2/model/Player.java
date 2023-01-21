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
@Table(name = "player")
public class Player implements Serializable {
    @Id
    @SequenceGenerator(name = "player_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    private Integer id;
    @Column(length = 100)
    private String name;
    private Integer number;
    @Column(name = "is_guardian", columnDefinition = "boolean default false")
    private boolean isGuardian;
    @ManyToOne
    private Team team;
}
