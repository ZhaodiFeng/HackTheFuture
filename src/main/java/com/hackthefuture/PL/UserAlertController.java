package com.hackthefuture.PL;

import com.hackthefuture.DAL.models.Alert;
import com.hackthefuture.DAL.repositories.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/alert")
    public ModelAndView insertNewAlert(
            @ModelAttribute Alert alert,
            final RedirectAttributes redirectAttributes) {




        alertRepository.insert(alert);



        return new ModelAndView("redirect:/user/alert");
    }
}
