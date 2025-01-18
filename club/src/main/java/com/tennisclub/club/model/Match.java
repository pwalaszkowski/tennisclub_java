package com.tennisclub.club.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String player1;
    private String player2;
    private String winner;
    private String score;
}