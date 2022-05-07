package com.example.mygraphql.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book {
    private Long id;
    private String title;
    private Integer year;
    private Author author;
}
