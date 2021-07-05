package com.example.graphqldemo.context;

import graphql.kickstart.servlet.context.GraphQLServletContext;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.dataloader.DataLoaderRegistry;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Setter
@Getter
@RequiredArgsConstructor
public class CustomGraphQLContext implements GraphQLServletContext {

    private final String userId;    //the only new variable

    private final GraphQLServletContext context;


    //these method mimic the default GraphQLServletContext
    @Override
    public List<Part> getFileParts() {
        return context.getFileParts();
    }

    @Override
    public Map<String, List<Part>> getParts() {
        return context.getParts();
    }

    @Override
    public HttpServletRequest getHttpServletRequest() {
        return context.getHttpServletRequest();
    }

    @Override
    public HttpServletResponse getHttpServletResponse() {
        return context.getHttpServletResponse();
    }

    @Override
    public Optional<Subject> getSubject() {
        return context.getSubject();
    }

    @Override
    public @NonNull DataLoaderRegistry getDataLoaderRegistry() {
        return context.getDataLoaderRegistry();
    }
}
