package com.hackthefuture.PL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fengz on 30-Nov-17.
 */
@RestController
@RequestMapping("/")
public class MainController {
    @GetMapping()
    public ModelAndView homee(){
        return new ModelAndView("redirect:/welcome");
    }
    @GetMapping("/welcome")
    public ModelAndView welcome(){
        return new ModelAndView("Welcome");
    }

}
