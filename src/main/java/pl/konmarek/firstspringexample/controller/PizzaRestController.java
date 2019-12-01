package pl.konmarek.firstspringexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.konmarek.firstspringexample.pizza.Pizza;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaRestController {

    @GetMapping("/menu")
    List<Pizza> getMenu() {
        return Pizza.getPizzas();
    }
}