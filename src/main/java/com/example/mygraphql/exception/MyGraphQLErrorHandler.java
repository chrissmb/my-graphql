package com.example.mygraphql.exception;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.DefaultGraphQLErrorHandler;
import graphql.servlet.GenericGraphQLError;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyGraphQLErrorHandler extends DefaultGraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        errors = errors.stream().map(this::mapBusinessException).collect(Collectors.toList());
        return super.processErrors(errors);
    }

    private GraphQLError mapBusinessException(GraphQLError error) {
        if (!isBusinessException(error)) {
            return error;
        }
        BusinessException businessException = (BusinessException) ((ExceptionWhileDataFetching) error).getException();
        return new GenericGraphQLError(businessException.getMessage());
    }

    private boolean isBusinessException(GraphQLError error) {
        return error instanceof ExceptionWhileDataFetching &&
                ((ExceptionWhileDataFetching) error).getException()  instanceof BusinessException;
    }
}
