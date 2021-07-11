package com.example.graphqldemo.repository;

import com.example.graphqldemo.domain.BankAccount;
import com.example.graphqldemo.domain.Currency;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//mock for bank accounts
@Component
public class BankAccountRepository {

    //mockup
    private final List<BankAccount> bankAccounts = List.of(
            BankAccount.builder()
                    .id(UUID.fromString("a418a904-351c-4f32-b763-96e15515d7c4"))
                    .name("test1")
                    .currency(Currency.USD)
                    .createdAt(ZonedDateTime.parse("2021-07-04T23:30:00+00:00"))
                    .build(),
            BankAccount.builder()
                    .id(UUID.fromString("f835d1a3-012a-4224-8621-346bc38f1d51"))
                    .name("test2")
                    .currency(Currency.USD)
                    .createdAt(ZonedDateTime.parse("2021-07-04T23:30:00+00:00"))
                    .build(),
            BankAccount.builder()
                    .id(UUID.fromString("24cd7105-0608-4fc1-bd15-131185f24407"))
                    .name("test3")
                    .currency(Currency.USD)
                    .createdAt(ZonedDateTime.parse("2021-07-04T23:30:00+00:00"))
                    .build(),
            BankAccount.builder()
                    .id(UUID.fromString("42e53878-898e-45e4-aa35-0047e1412032"))
                    .name("test4")
                    .currency(Currency.USD)
                    .createdAt(ZonedDateTime.parse("2021-07-04T23:30:00+00:00"))
                    .build()
    ).stream()
            .sorted(Comparator.comparing(BankAccount::getId))
            .collect(Collectors.toList());


    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }


    public List<BankAccount> getBankAccountsAfter(UUID id) {
        return bankAccounts.stream()
                .dropWhile(bankAccount -> bankAccount.getId().compareTo(id) != 1)
                .collect(Collectors.toUnmodifiableList());
    }

}
