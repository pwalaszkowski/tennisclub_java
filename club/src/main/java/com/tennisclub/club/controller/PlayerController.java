package com.tennisclub.club.controller;

import com.tennisclub.club.model.Player;
import com.tennisclub.club.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String listPlayers(Model model) {
        model.addAttribute("players", playerService.findAll());
        return "players/list";
    }

    @GetMapping("/new")
    public String newPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        return "players/form";
    }

    @PostMapping
    public String savePlayer(@ModelAttribute Player player) {
        playerService.save(player);
        return "redirect:/players";
    }

    @GetMapping("/{id}/delete")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deleteById(id);
        return "redirect:/players";
    }
}