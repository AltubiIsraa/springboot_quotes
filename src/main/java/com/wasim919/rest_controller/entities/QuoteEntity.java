package com.wasim919.rest_controller.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// Lombok will generate all the getters, setters and constructors
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuoteEntity {
    // automatically increment id
    // the id is uuid
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String text;
}
