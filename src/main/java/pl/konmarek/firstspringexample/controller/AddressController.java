package pl.konmarek.firstspringexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.konmarek.firstspringexample.domain.Address;

@Controller
@RequestMapping("/view/ad")
public class AddressController {

    @GetMapping("/new-way")
    public ModelAndView getMyAddress(ModelAndView modelAndView){

        modelAndView.addObject("mojAdres", new Address("wwa", "xxx","00-010"));
        modelAndView.setViewName("address");
        return modelAndView;
    }

    @GetMapping("/old-way")
    public String getAddress(Model model){

        model.addAttribute("mojAdres", new Address("wwa", "xxx","00-010"));
        return "address";
    }
}
