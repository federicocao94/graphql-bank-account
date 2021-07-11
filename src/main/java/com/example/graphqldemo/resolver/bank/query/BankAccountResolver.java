package com.example.graphqldemo.resolver.bank.query;

import com.example.graphqldemo.context.dataloader.DataLoaderRegistryFactory;
import com.example.graphqldemo.domain.BankAccount;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLResolver<BankAccount> {

    /**
     * It retrieves asynchronously the balance for every account.
     * When all data are fetched, the result is dispatched.
     * It calls DataLoaderRegistryFactory.createBalanceDataLoader with all the requested IDs
     */
    public CompletableFuture<BigDecimal> balance(BankAccount bankAccount,
                                                 DataFetchingEnvironment environment) {
        log.info("Getting balance for {}", bankAccount.getId());

        DataLoader<UUID, BigDecimal> dataLoader = environment.getDataLoader(
                DataLoaderRegistryFactory.BALANCE_DATA_LOADER);

        return dataLoader.load(bankAccount.getId());
    }

}
