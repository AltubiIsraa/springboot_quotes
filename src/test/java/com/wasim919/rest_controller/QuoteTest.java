package com.wasim919.rest_controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wasim919.rest_controller.entities.QuoteEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuoteTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getAllQuotes() throws  Exception {
        RequestBuilder requestBuilder = get("/quote");
        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(status().is(200));
    }


    @Test
    void saveQuote() throws  Exception {
        QuoteEntity quoteEntity = new QuoteEntity(100L, "test1");
        RequestBuilder request = post("/quote")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(quoteEntity));
        mockMvc.perform(request).andExpect(status().isOk()).andExpect(status().is(200));
    }
}