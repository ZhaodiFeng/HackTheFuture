package com.hackthefuture;

import com.hackthefuture.DAL.models.User;
import com.hackthefuture.DAL.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengz on 30-Nov-17.
 */
@Component
public class StartUpListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        if (userRepository.findAll().isEmpty()) {
            User user = new User();
            user.setUsername("admin");
            List<String> autho = new ArrayList<String>();
            autho.add("admin");
            user.setAuthorities(autho);
            user.setPassword(passwordEncoder.encode("123"));
            user.setActive(true);
            userRepository.save(user);
            System.out.println("\n\n\nOk ");
        }else{
            System.out.println("\n\n\nOk ******************************************************");
        }

    }
}




