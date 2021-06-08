package com.example.graphqldemo.domain;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class BankAccount {

    UUID id;

    String name;

    Currency currency;

    UUID clientId;

}
