package com.example.graphqldemo.resolver.bank;

import com.example.graphqldemo.domain.BankAccount;
import com.example.graphqldemo.domain.Client;
import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {


    public Client client(BankAccount bankAccount) {
        log.info("Resolving client for bank account: " + bankAccount.getId());

        //test exception handler
//        throw new GraphQLException("client unavailable");

        //mockup, usually you have just the client ID, you should retrieve data using client ID
        return Client.builder()
                .id(UUID.randomUUID())
                .firstName("client 1")
                .lastName("first")
                .build();
    }


    //Asynchronous resolver
//    private final ExecutorService executorService = Executors.newFixedThreadPool(
//            Runtime.getRuntime().availableProcessors()
//    );
//
//
//    public CompletableFuture<Client> client(BankAccount bankAccount) {
//        log.info("Resolving client for bank account: " + bankAccount.getId());
//
//        return CompletableFuture.supplyAsync(
//                () -> {
//                    log.info();
//                    return Client.builder()
//                            .id(UUID.randomUUID())
//                            .firstName("client 1")
//                            .lastName("first")
//                            .build();
//                },
//                executorService
//        );
//    }

}
