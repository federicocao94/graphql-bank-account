package com.example.graphqldemo.domain.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateBankAccountInput {

    @NotBlank
    String name;

    int age;

}
