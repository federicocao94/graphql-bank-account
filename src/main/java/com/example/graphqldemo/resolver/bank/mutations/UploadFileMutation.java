package com.example.graphqldemo.resolver.bank.mutations;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

/*
    create a POST request to localhost:8080/graphql using Postman
    select body -> form-data
    add the keys: operations value {"query": "mutation { uploadFile }", "varialbes": {}}
    and file value (select type file instead of text) and select a file
 */

@Slf4j
@Component
public class UploadFileMutation implements GraphQLMutationResolver {

    //DataFetchingEnvironment must be the last param of the mutation
    public UUID uploadFile(DataFetchingEnvironment environment) {
        DefaultGraphQLServletContext context = environment.getContext();

        context.getFileParts().forEach(part -> {
            log.info("uploading: {}, size: {}", part.getSubmittedFileName(), part.getSize());

        });

        return UUID.randomUUID();
    }

}
