package pl.konmarek.firstspringexample.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import pl.konmarek.firstspringexample.pizza.Pizza;

import java.util.Arrays;
import java.util.List;

@Repository
public class PizzaRepo {

    private static final Logger logger = LoggerFactory.getLogger(PizzaRepo.class);

    public static final List<Pizza> pizzas = Arrays.asList(
            new Pizza(35, 50, "hawajska",
                    Arrays.asList("sos pomidorowy", "ser", "szynka", "ananas")),
            new Pizza(25, 50, "margherita",
                    Arrays.asList("sos pomidorowy", "ser")),
            new Pizza(40, 50, "capriciosa",
                    Arrays.asList("sos pomidorowy", "ser", "szynka", "pieczarki")));

    public List<Pizza> getAllPizzas() {

        logger.info("getAllPizzas(), returned {} pizzas", pizzas.size());
        return pizzas;
    }
}
