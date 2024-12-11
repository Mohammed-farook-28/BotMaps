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
@Document(collection = "country")
public class Country {
    @Id
    private String id;                   
    private String name;                 
    private String code;                 
    private String capital;              
    private String flagUrl;              
    private String continent;            
    private long population;             
    private double area;                 
    private String description;          
    private List<Place> placesToVisit;   
    private String visaInfoUrl;          
    private Details details;             
    private Currency currency;           

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Place {
        private String name;            
        private String imageUrl;        
        private String description;     
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Details {
        private List<String> popularDestinations; 
        private String travelTips;                
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Currency {
        private String code;              
        private double rateToUSD;         
        private String symbol;            
    }
}
