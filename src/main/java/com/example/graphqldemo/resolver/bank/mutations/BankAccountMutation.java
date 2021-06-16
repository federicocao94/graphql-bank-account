package com.example.graphqldemo.resolver.bank.mutations;

import com.example.graphqldemo.domain.BankAccount;
import com.example.graphqldemo.domain.Currency;
import com.example.graphqldemo.domain.input.CreateBankAccountInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountMutation implements GraphQLMutationResolver {

    public BankAccount createBankAccount(CreateBankAccountInput input) {
        log.info("creating account for {}", input);

        return BankAccount.builder()
                .id(UUID.randomUUID())
                .currency(Currency.USD)
                .name(input.getName())
                .build();
    }

}
