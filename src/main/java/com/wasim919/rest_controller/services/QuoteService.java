package com.wasim919.rest_controller.services;

import com.wasim919.rest_controller.entities.QuoteEntity;
import com.wasim919.rest_controller.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public QuoteEntity saveQuote(String text) {
        QuoteEntity quoteEntity = QuoteEntity.builder()
                .text(text).build();
        // new QuoteEntity(text);
        return this.quoteRepository.save(quoteEntity);
    }

    public List<QuoteEntity> getQuotes() {
        return this.quoteRepository.findAll();
    }
}
