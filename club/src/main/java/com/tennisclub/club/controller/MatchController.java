package com.tennisclub.club.controller;

import com.tennisclub.club.model.Match;
import com.tennisclub.club.service.MatchService;
import com.tennisclub.club.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/matches")
public class MatchController {
    private final MatchService matchService;
    private final PlayerService playerService;

    public MatchController(MatchService matchService, PlayerService playerService) {
        this.matchService = matchService;
        this.playerService = playerService;
    }

    // Display all matches
    @GetMapping
    public String listMatches(Model model) {
        model.addAttribute("matches", matchService.findAll());
        return "matches/list";
    }

    // Display the form for adding a new match
    @GetMapping("/new")
    public String newMatchForm(Model model) {
        model.addAttribute("match", new Match());
        model.addAttribute("players", playerService.findAll()); // Pass the players for dropdown
        return "matches/form";
    }

    // Save a new match
    @PostMapping
    public String saveMatch(@ModelAttribute Match match, RedirectAttributes redirectAttributes) {
        matchService.save(match);
        redirectAttributes.addFlashAttribute("successMessage", "Result has been saved successfully!");
        return "redirect:/matches";
    }

    // Display the form for editing an existing match
    @GetMapping("/{id}")
    public String editMatchForm(@PathVariable Long id, Model model) {
        model.addAttribute("match", matchService.findById(id));
        model.addAttribute("players", playerService.findAll()); // Pass players for dropdown in edit form
        return "matches/form";
    }

    // Update an existing match
    @PostMapping("/{id}")
    public String updateMatch(@PathVariable Long id, @ModelAttribute Match match, RedirectAttributes redirectAttributes) {
        matchService.save(match);
        redirectAttributes.addFlashAttribute("successMessage", "Result has been updated successfully!");
        return "redirect:/matches";
    }

    // Delete a match
    @GetMapping("/{id}/delete")
    public String deleteMatch(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        matchService.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Result has been deleted successfully!");
        return "redirect:/matches";
    }
}
