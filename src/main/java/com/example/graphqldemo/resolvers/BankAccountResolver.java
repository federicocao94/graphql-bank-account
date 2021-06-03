package com.example.graphqldemo.resolvers;

import com.example.graphqldemo.domain.BankAccount;
import com.example.graphqldemo.domain.Client;
import com.example.graphqldemo.domain.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id) {
        log.info("Retrieving bank account id: {}", id);

        Client clientA = Client.builder()
                .id(UUID.randomUUID())
                .firstName("client a")
                .lastName("lastname")
                .build();

        Client clientB = Client.builder()
                .id(UUID.randomUUID())
                .firstName("client b")
                .lastName("lastname")
                .build();

        clientA.setClient(clientB);
        clientB.setClient(clientA);



        return BankAccount.builder()
                .id(id)
                .currency(Currency.EUR)
                .name("Federico")
                .client(clientA)
                .build();
    }

}
