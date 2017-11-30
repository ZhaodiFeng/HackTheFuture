package com.hackthefuture.PL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fengz on 30-Nov-17.
 */
public class MainController {
    @GetMapping("/welcome")
    public ModelAndView welcome(){
        return new ModelAndView("Welcome");
    }

}
