package pl.konmarek.firstspringexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.konmarek.firstspringexample.service.PizzaService;

@Controller
@RequestMapping("/view")
public class PizzaController {

    private static final Logger logger = LoggerFactory.getLogger(PizzaController.class);
    private PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    // /view/pizzas
    // http://localhost:8081/view/pizzas?provider=PizzaHut
    @GetMapping("/pizzas")
    public String getMenu(Model model,
                          @RequestParam(value = "provider", defaultValue = "SDA pizza") String pizzaProvider){

        logger.info("received pizzaProvider: [{}]", pizzaProvider);



        //model.put("key", value)
        model.addAttribute("localName", pizzaProvider);
        model.addAttribute("allpizzas", pizzaService.getAllPizzasInMenu());
        return "menu/my-menu";
    }
}
