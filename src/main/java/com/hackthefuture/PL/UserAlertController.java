package com.hackthefuture.PL;

import com.hackthefuture.DAL.models.Alert;
import com.hackthefuture.DAL.repositories.AlertRepository;
import com.hackthefuture.DAL.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by kaisu on 30/11/2017.
 */
@RestController
@RequestMapping("/user")
public class UserAlertController {

    @Autowired
    private AlertRepository alertRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/alert/{username}")
    public ModelAndView getAlert(
            Model model,
            @PathVariable("username") String username){
        model.addAttribute("user", userRepository.findByUsername(username));
        return new ModelAndView("userPage");
    }


    @PostMapping("/alert")
    public ModelAndView insertNewAlert(
            @ModelAttribute Alert alert,
            final RedirectAttributes redirectAttributes) {




        alertRepository.insert(alert);



        return new ModelAndView("redirect:/user/alert");
    }
}
