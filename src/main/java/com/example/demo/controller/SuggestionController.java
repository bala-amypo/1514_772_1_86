package com.example.demo.controller;

import com.example.demo.service.SuggestionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @GetMapping
    public Object getSuggestions(HttpServletRequest request) {

        // HEADER VALUE IS STRING → CONVERT TO LONG
        Long userId = Long.parseLong(request.getHeader("userId"));

        return suggestionService.getSuggestions(userId);
    }
}
