package com.tennisclub.club.controller;

import com.tennisclub.club.model.Match;
import com.tennisclub.club.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String saveMatch(@ModelAttribute Match match, RedirectAttributes redirectAttributes) {
        matchService.save(match);
        redirectAttributes.addFlashAttribute("successMessage", "Result has been saved successfully!");
        return "redirect:/matches";
    }

    @GetMapping("/{id}")
    public String editMatchForm(@PathVariable Long id, Model model) {
        model.addAttribute("match", matchService.findById(id));
        return "matches/form";
    }

    @PostMapping("/{id}")
    public String updateMatch(@PathVariable Long id, @ModelAttribute Match match, RedirectAttributes redirectAttributes) {
        matchService.save(match);
        redirectAttributes.addFlashAttribute("successMessage", "Result has been updated successfully!");
        return "redirect:/matches";
    }

    @GetMapping("/{id}/delete")
    public String deleteMatch(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        matchService.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Result has been deleted successfully!");
        return "redirect:/matches";
    }
}
