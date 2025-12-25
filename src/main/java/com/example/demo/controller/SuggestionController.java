package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggestions")
@RequiredArgsConstructor
public class SuggestionController {

    private final SuggestionService suggestionService;

    @PostMapping
    public Suggestion save(@Valid @RequestBody Suggestion suggestion) {
        return suggestionService.saveSuggestion(suggestion);
    }

    @GetMapping
    public List<Suggestion> getAll() {
        return suggestionService.getAllSuggestions();
    }
}
