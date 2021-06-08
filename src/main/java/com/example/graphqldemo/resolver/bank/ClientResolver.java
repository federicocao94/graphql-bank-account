package com.example.graphqldemo.resolver.bank;

import com.example.graphqldemo.domain.BankAccount;
import com.example.graphqldemo.domain.Client;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    public Client client(BankAccount bankAccount) {
        log.info("Resolving client for bank account: " + bankAccount.getId());

        //mockup, usually you have just the client ID, you should retrieve data using client ID
        return Client.builder()
                .id(UUID.randomUUID())
                .firstName("client 1")
                .lastName("first")
                .build();
    }

}
