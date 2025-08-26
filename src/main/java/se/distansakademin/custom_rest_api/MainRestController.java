package se.distansakademin.custom_rest_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.distansakademin.custom_rest_api.data.PizzaRepository;
import se.distansakademin.custom_rest_api.models.Pizza;

import java.util.HashMap;


@RestController
public class MainRestController {

    private PizzaRepository pizzaRepository = new PizzaRepository();

    // http://localhost:8080/test
    @GetMapping("/test")
    public String getTest(){
        return "OK";
    }

    // http://localhost:8080/pizzas
    @GetMapping("/pizzas")
    public HashMap<Integer, Pizza> getPizza(){
        return pizzaRepository.getAll();
    }
}
