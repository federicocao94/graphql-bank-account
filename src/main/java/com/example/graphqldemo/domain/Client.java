package com.example.graphqldemo.domain;

import lombok.Builder;
import lombok.Setter;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Builder
@Setter
public class Client {

    UUID id;

    String firstName;

    List<String> middleNames;

    String lastName;

    Client client;

}
