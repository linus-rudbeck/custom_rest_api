package se.distansakademin.custom_rest_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pizza {
    private String name;
    private String description;
    private int price;

}
