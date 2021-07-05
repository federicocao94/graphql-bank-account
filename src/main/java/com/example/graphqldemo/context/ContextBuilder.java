package com.example.graphqldemo.context;

import graphql.kickstart.execution.context.GraphQLContext;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.servlet.context.GraphQLServletContextBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

@Slf4j
@Component
public class ContextBuilder implements GraphQLServletContextBuilder {

    //this context is created once and we can use it in any resolver/mutation
    //every resolver method can have a parameter environment from which we can get context
    @Override
    public GraphQLContext build(HttpServletRequest request, HttpServletResponse response) {
        var userId = request.getHeader("user_id");

        DefaultGraphQLServletContext context = DefaultGraphQLServletContext.createServletContext()
                .with(request)
                .with(response)
                .build();

        return new CustomGraphQLContext(userId, context);
    }


    //http servlet is the only one allowed in this case
    @Override
    public GraphQLContext build(Session session, HandshakeRequest request) {
        throw new IllegalStateException("Illegal access");
    }


    @Override
    public GraphQLContext build() {
        throw new IllegalStateException("Illegal access");
    }

}
