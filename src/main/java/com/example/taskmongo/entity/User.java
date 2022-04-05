package com.example.taskmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
@AllArgsConstructor
public class User {

    @Id
    @Field(value = "email")
    private String email;

    @Field(value = "name")
    private String name;
}
