package pl.konmarek.firstspringexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.konmarek.firstspringexample.domain.Owner;
import pl.konmarek.firstspringexample.service.OwnerService;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    private static final Logger logger = LoggerFactory.getLogger(OwnerController.class);
    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    // /owner/all-owners
    @GetMapping("/all_owners")
    public ModelAndView allOwners(ModelAndView modelAndView) {
        modelAndView.addObject("posiadacze", ownerService.allOwners());
        modelAndView.setViewName("owner/owners");
        return modelAndView;
    }

    // /owner/new-owner-form
    @GetMapping("/new-owner-form")
    public ModelAndView newOwnerForm(ModelAndView modelAndView) {
        logger.info("displaying new owner form");
        modelAndView.setViewName("owner/new_owner");
        return modelAndView;
    }

    @PostMapping("/save")
//    public ModelAndView saveOwner(ModelAndView modelAndView, @RequestParam("nick") String name) {
    public String saveOwner(Owner owner) {
        logger.info("maybe save:)");
        logger.info("nick: [{}]", owner);
        ownerService.saveOwner(owner);
        return "redirect:/owner/all_owners";
    }
}
