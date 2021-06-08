package com.example.graphqldemo.resolver.bank.query;

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

        return BankAccount.builder()
                .id(id)
                .currency(Currency.EUR)
                .name("Federico")
                .build();
    }

}
