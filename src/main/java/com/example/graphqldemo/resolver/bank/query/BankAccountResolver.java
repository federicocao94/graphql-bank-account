package com.example.graphqldemo.resolver.bank.query;

import com.example.graphqldemo.connection.CursorUtil;
import com.example.graphqldemo.context.CustomGraphQLContext;
import com.example.graphqldemo.domain.BankAccount;
import com.example.graphqldemo.domain.Currency;
import com.example.graphqldemo.repository.BankAccountRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.*;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class BankAccountResolver implements GraphQLQueryResolver {

    private final BankAccountRepository bankAccountRepository;

    private final CursorUtil cursorUtil;


    public BankAccount bankAccount(UUID id, DataFetchingEnvironment environment) {
        log.info("Retrieving bank account id: {}", id);

        CustomGraphQLContext context = environment.getContext();
        log.info("User ID: {}", context.getUserId());

        return BankAccount.builder()
                .id(id)
                .currency(Currency.EUR)
                .name("Federico")
                .build();
    }


    public Connection<BankAccount> bankAccounts(int first, @Nullable String cursor) {

        List<Edge<BankAccount>> edges = getBankAccounts(cursor)
                .stream()
                .limit(first)
                .map(bankAccount -> {
                    return new DefaultEdge<>(bankAccount, cursorUtil.createCursorWith(bankAccount.getId()));
                })
                .collect(Collectors.toList());

        //in real implementation perform a query for hasPreviousPage (3) and hasNextPage (4)
        var pageInfo = new DefaultPageInfo(cursorUtil.getFirstCursorFrom(edges),
                cursorUtil.getLastCursorFrom(edges),
                cursor != null, edges.size() >= first);

        return new DefaultConnection<>(edges, pageInfo);
    }


    private List<BankAccount> getBankAccounts(String cursor) {
        if(cursor == null) {
            return bankAccountRepository.getBankAccounts();
        }

        return bankAccountRepository.getBankAccountsAfter(cursorUtil.decodeCursorWith(cursor));
    }

}
