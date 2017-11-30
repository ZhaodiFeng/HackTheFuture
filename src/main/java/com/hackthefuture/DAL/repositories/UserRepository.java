package com.hackthefuture.DAL.repositories;

import com.hackthefuture.DAL.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by kaisu on 30/11/2017.
 */
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByUsername(String username);

    List<User> findAllByUsernameContaining(String string);

    User findById(int id);

    void deleteUsersByUsername(String username);
}
