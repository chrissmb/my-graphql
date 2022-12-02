package com.example.mygraphql.entity;

import lombok.Data;

@Data
public class BookInput {

    private Long id;
    private String title;
    private Integer year;
}
