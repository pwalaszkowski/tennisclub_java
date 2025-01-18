package com.tennisclub.club.controller;

import com.tennisclub.club.model.Match;
import com.tennisclub.club.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/matches")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public String listMatches(Model model) {
        model.addAttribute("matches", matchService.findAll());
        return "matches/list";
    }

    @GetMapping("/new")
    public String newMatchForm(Model model) {
        model.addAttribute("match", new Match());
        return "matches/form";
    }

    @PostMapping
    public String saveMatch(@ModelAttribute Match match) {
        matchService.save(match);
        return "redirect:/matches";
    }

    @GetMapping("/{id}")
    public String editMatchForm(@PathVariable Long id, Model model) {
        model.addAttribute("match", matchService.findById(id));
        return "matches/form";
    }

    @GetMapping("/{id}/delete")
    public String deleteMatch(@PathVariable Long id) {
        matchService.deleteById(id);
        return "redirect:/matches";
    }
}