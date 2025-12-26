package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
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

    @PostMapping("/{farmId}")
    public Suggestion generateSuggestion(
            @PathVariable Long farmId,
            HttpServletRequest request
    ) {
        Long userId = Long.parseLong(request.getHeader("userId"));
        return suggestionService.generateSuggestion(farmId, userId);
    }
}
