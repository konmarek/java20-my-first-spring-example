package pl.konmarek.firstspringexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MyFirstController {

    private static final Logger logger = LoggerFactory.getLogger(MyFirstController.class);

    @GetMapping("/welcome")
    String homePage(@RequestParam(value = "name", defaultValue = "Jan") String imie,
                    @RequestParam(value = "surname", defaultValue = "Nowak") String nazwisko,
                    Model model){
        logger.info("inside homePage()");

        logger.info("params, name[{}], surname[{}]", imie, nazwisko);

        model.addAttribute("hName", imie);
        model.addAttribute("hSurame", nazwisko);

        return "home";
    }
    @GetMapping("/about")
    String aboutPage(@RequestParam(value = "brand", defaultValue = "polski fiat") String marka,
                     @RequestParam(value = "model", defaultValue = "126p") String model,
                     @RequestParam(value = "milage", defaultValue = "89563") String przebieg,
                     Model modelinio){
        logger.info("inside aboutPage()");
        logger.info("parametry: brand[{}], model[{}], milage[{}]", marka, model, przebieg);

        modelinio.addAttribute("hMarka", marka);
        modelinio.addAttribute("hModel", model);
        modelinio.addAttribute("hMilage", przebieg);

        return "about";
    }
}
