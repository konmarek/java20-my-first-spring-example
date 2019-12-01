package pl.konmarek.firstspringexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.konmarek.firstspringexample.domain.Pet;
import pl.konmarek.firstspringexample.repository.PetRepository;
import pl.konmarek.firstspringexample.service.PetService;

@Controller
@RequestMapping("/pets")
public class PetController {

    private static final Logger logger = LoggerFactory.getLogger(PetService.class);
    private PetService dostawca;

    public PetController(PetService dostawca) {
        this.dostawca = dostawca;
    }

    //?id=5
    @GetMapping("/pet/{id}")
    public ModelAndView displayPetOfId(ModelAndView modelAndView,
                                       @PathVariable("id") Long id){

        modelAndView.addObject("twojPet", dostawca.findPetById(id).orElse(new Pet()));
        modelAndView.setViewName("pet/favourite-pet");
        return modelAndView;
    }
}
