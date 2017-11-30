package com.hackthefuture.PL;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fengz on 30-Nov-17.
 */

@RestController
public class AuthenticationController {

    @GetMapping("/login")
    public ModelAndView login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/welcome");
        }
        return new ModelAndView("Login");
    }
}

