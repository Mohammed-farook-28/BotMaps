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
@Document(collection = "user_country")
public class UserCountry {
    @Id
    private String id;
    private String userId;
    private String countryCode;
    private boolean visited;
    private String notes;
    private List<String> photoUrls;
    private List<Person> peopleMet;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person {
        private String id; // Unique identifier for the person
        private String name;
        private String nationality;
        private String contact;
        private String whatsapp;
        private String instagram;
        private String youtube;
        private String facebook;
        private String whereMet;
    }
}
