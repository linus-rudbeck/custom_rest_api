package se.distansakademin.custom_rest_api.data;

import se.distansakademin.custom_rest_api.models.Pizza;

import java.util.ArrayList;
import java.util.HashMap;

public class PizzaResponse extends Pizza {
    private final int id;

    public PizzaResponse(int id, Pizza pizza){
        this(id, pizza.getName(), pizza.getDescription(), pizza.getPrice());
    }

    public PizzaResponse(int id, String name, String description, int price) {
        super(name, description, price);
        this.id = id;
    }

    public static ArrayList<PizzaResponse> fromHashMap(HashMap<Integer, Pizza> pizzaMap){
        var pizzaList = new ArrayList<PizzaResponse>();
        pizzaMap.forEach( (id, pizza) -> {pizzaList.add(new PizzaResponse(id, pizza)); } );
        return pizzaList;
    }
}
