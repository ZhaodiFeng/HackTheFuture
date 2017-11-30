package com.hackthefuture.Authentication;

/**
 * Created by fengz on 30-Nov-17.
 */

import com.hackthefuture.DAL.models.User;
import com.hackthefuture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    //  private MongoClient mongoClient;
            UserRepository userRepository;

    /**
     * Find authentication userdatails van user door username
     *
     * @param username username
     * @return UserDatails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).get(0);
        if (user != null && user.getActive()) {
            String password = user.getPassword();
            List<String> authorities = user.getAuthorities();
            MongoUserDetails mongoUserDetails = new MongoUserDetails(username, password, authorities.toArray(new String[authorities.size()]));
            return mongoUserDetails;
        }
        return null;
    }
}