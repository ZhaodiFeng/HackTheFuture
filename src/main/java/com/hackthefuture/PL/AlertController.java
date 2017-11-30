package com.hackthefuture.PL;

import com.hackthefuture.DAL.models.Alert;
import com.hackthefuture.DAL.repositories.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kaisu on 30/11/2017.
 */
@RestController
@RequestMapping("/data")
public class AlertController {

    @Autowired
    private AlertRepository alertRepository;

    @GetMapping("/alerts")
    public List<Alert> getAlerts() {
        return alertRepository.findAll();
    }

    @GetMapping("/alerts/{id}")
    public Alert getAlert(@PathVariable("id") int id) {
        return alertRepository.getById(id);
    }

}
