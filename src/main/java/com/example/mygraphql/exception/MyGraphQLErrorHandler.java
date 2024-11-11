package com.example.mygraphql.exception;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.spring.error.ErrorContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class MyGraphQLErrorHandler {

    @ExceptionHandler(BusinessException.class)
    public GraphQLError businessExceptionHandler(BusinessException e, ErrorContext errorContext) {
        return new GenericGraphQLError("Business exception " + e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public GraphQLError generalExceptionHandler(Throwable e) {
        return new GenericGraphQLError("Unknown error: " + e.getMessage());
    }

}
