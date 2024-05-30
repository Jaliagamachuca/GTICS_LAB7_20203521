package com.example.gtics_lab7_20203521.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "players")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerId", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Column(name = "mmr", nullable = false)
    private Integer mmr;

    @Column(name = "position", nullable = false)
    private Integer position;

    @Column(name = "region", nullable = false, length = 40)
    private String region;

}