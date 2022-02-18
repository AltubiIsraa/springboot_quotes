package com.wasim919.rest_controller.controllers;

import com.sun.istack.NotNull;
import com.wasim919.rest_controller.entities.QuoteEntity;
import com.wasim919.rest_controller.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    private QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/hello")
    public String getHello() {
        return "Hello";
    }

    @PostMapping
    public String saveQuote(@RequestBody @NotNull String text) {
        QuoteEntity quoteEntity = this.quoteService.saveQuote(text);
        return quoteEntity.getText();
    }

    @GetMapping
    public List<String> getQuotes() {
        List<QuoteEntity> quoteEntities = this.quoteService.getQuotes();
        List<String> quotes = quoteEntities.stream().map(QuoteEntity::getText).collect(Collectors.toList());
        return quotes;
    }
}
