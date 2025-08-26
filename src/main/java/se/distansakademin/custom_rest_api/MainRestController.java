package se.distansakademin.custom_rest_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.distansakademin.custom_rest_api.data.PizzaRepository;
import se.distansakademin.custom_rest_api.data.PizzaResponse;
import se.distansakademin.custom_rest_api.models.Pizza;

import java.util.Collection;
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
    public Collection<PizzaResponse> getPizzas(){
        var pizzas = pizzaRepository.getAll();
        return PizzaResponse.fromHashMap(pizzas);
    }

    // http://localhost:8080/pizzas/5
    @GetMapping("/pizzas/{id}")
    public PizzaResponse getPizza(@PathVariable int id){
        try {
            var pizza = pizzaRepository.get(id);
            return new PizzaResponse(id, pizza);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
