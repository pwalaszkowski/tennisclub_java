package com.tennisclub.club.repository;

import com.tennisclub.club.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}