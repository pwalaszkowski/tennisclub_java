package com.tennisclub.club.service;

import com.tennisclub.club.model.Match;
import com.tennisclub.club.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> findAll() {
        return matchRepository.findAll();
    }

    public Match findById(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    public Match save(Match match) {
        return matchRepository.save(match);
    }

    public void deleteById(Long id) {
        matchRepository.deleteById(id);
    }
}
