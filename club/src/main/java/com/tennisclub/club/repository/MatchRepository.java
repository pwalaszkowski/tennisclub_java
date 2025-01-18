package com.tennisclub.club.repository;

import com.tennisclub.club.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}