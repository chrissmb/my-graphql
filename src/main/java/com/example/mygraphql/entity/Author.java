package com.example.mygraphql.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Author {
    private Long id;
    private String name;
}
