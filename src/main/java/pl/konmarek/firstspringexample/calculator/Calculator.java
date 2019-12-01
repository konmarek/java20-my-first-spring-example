package pl.konmarek.firstspringexample.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class Calculator {

    private static final Logger logger = LoggerFactory.getLogger("Calculator");

    //calculate-sum/3/4 ->
    @GetMapping("/calculate-sum/{sklad_1}/{sklad_2}")  //mapowanie adresu na wywolanie metody
    public int sum(@PathVariable("sklad_2") Integer a,
                   @PathVariable("sklad_1") Integer b){
        return a + b;
    }

    @GetMapping("/calculate-sub/{sklad_3}/{sklad_4}")
    public int sub(@PathVariable("sklad_3") int c,
                   @PathVariable("sklad_4") int d){
        return c - d;
    }

    // wywolanie -> http://localhost:8081/mult?first=10&second=9
    @GetMapping("/mult")
    public  Long mult(@RequestParam(value = "first", defaultValue = "0") Long param1,
                      @RequestParam(value = "second", defaultValue = "0") Long param2){

        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error message");
        return param1*param2;
    }

    @GetMapping("/div")
    public Double div(@RequestParam(value = "first", defaultValue = "0") Double a,
                      @RequestParam(value = "second", defaultValue = "0") Double b){
        return a/b;
    }
}
