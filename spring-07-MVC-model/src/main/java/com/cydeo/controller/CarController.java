package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    /**
     * query param examples
     */
    @RequestMapping("/info")  // localhost:8080/car/info?make=Honda
    public String carInfo(@RequestParam String make){

        System.out.println(make); // will print Honda
        return "car/carInfo";
    }

    @RequestMapping("/info2")  // localhost:8080/car/info - will give error if user does not provide any query param in the url
    public String carInfoWithRequiredQueryParam(@RequestParam() String make){

        System.out.println(make);
        return "car/carInfo";
    }
                                    // localhost:8080/car/info?make=Honda
    @RequestMapping("/info3")  // localhost:8080/car/info - will not give error even if user does not provide any query param in the url
    public String carInfoWithOptional(@RequestParam(required = false) String make){

        System.out.println(make);
        return "car/carInfo";
    }

    @RequestMapping("/info4")  // localhost:8080/car/info - if user does not provide, then will get Honda as default
    public String carInfoWithOptionalAndDefaultValue(@RequestParam(required = false, defaultValue = "Honda") String make){

        System.out.println(make); // will print Honda if user does not provide any query param.
        return "car/carInfo";
    }

    /**
     * path param examples
     */

    @RequestMapping("info5/{make}")
    public String carInfoWithPathVariable(@PathVariable String make, Model model){
        model.addAttribute("make", make);
        return "car/carInfo";

    }

}
