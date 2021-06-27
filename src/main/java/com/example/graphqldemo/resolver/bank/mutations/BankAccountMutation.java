package com.example.graphqldemo.resolver.bank.mutations;

import com.example.graphqldemo.domain.BankAccount;
import com.example.graphqldemo.domain.Currency;
import com.example.graphqldemo.domain.input.CreateBankAccountInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class BankAccountMutation implements GraphQLMutationResolver {

    private final Clock clock; //for unit testing

    public BankAccount createBankAccount(CreateBankAccountInput input) {
        log.info("creating account for {}", input);

        return BankAccount.builder()
                .id(UUID.randomUUID())
                .currency(Currency.USD)
                .name(input.getName())
                .createdAt(ZonedDateTime.now(clock))
                .createdOn(LocalDate.now(clock))
                .build();
    }

}
