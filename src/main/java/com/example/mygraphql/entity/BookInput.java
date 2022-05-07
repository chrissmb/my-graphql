package com.example.mygraphql.entity;

import graphql.schema.GraphQLInputType;
import lombok.Data;

@Data
public class BookInput implements GraphQLInputType {
    @Override
    public String getName() {
        return "qwe";
    }

    private Long id;
    private String title;
    private Integer year;
}
