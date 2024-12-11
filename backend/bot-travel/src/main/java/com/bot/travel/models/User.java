package com.bot.travel.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String userId;
    private String name;
    private int age;
    private String bloodGroup;
    private String address;
    private String profilePictureUrl;
    private List<String> hobbies;
    private String bio;
    private List<String> interests;
}
