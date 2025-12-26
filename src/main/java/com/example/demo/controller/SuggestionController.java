package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.SuggestionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestions")
@RequiredArgsConstructor
public class SuggestionController {

    private final SuggestionService suggestionService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/{farmId}")
    public Suggestion generateSuggestion(
            @PathVariable Long farmId,
            HttpServletRequest request) {

        Long userId = jwtTokenProvider.getUserIdFromRequest(request);
        return suggestionService.generateSuggestion(farmId, userId);
    }
}
