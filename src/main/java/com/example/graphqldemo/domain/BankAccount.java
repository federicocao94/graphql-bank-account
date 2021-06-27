package com.example.graphqldemo.domain;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Value
@Builder
public class BankAccount {

    UUID id;

    String name;

    Currency currency;

    UUID clientId;

    ZonedDateTime createdAt;

    LocalDate createdOn;

}
