package com.example.graphqldemo.exceptions;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class GraphqlExceptionHandler {

    @ExceptionHandler(GraphQLException.class)
    public ThrowableGraphQLError handle(GraphQLException e) {
        return new ThrowableGraphQLError(e);
    }


    //hide runtime exceptions messages like their stack traces
    @ExceptionHandler(RuntimeException.class)
    public ThrowableGraphQLError handle(RuntimeException e) {
        return new ThrowableGraphQLError(e, "Internal server error");
    }

}
