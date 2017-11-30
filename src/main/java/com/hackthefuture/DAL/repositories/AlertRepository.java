package com.hackthefuture.DAL.repositories;

import com.hackthefuture.DAL.models.Alert;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by kaisu on 30/11/2017.
 */
public interface AlertRepository extends MongoRepository<Alert, String> {

    List<Alert> getAll();

    Alert getById(int id);

    void addAlert(Alert alert);
}
