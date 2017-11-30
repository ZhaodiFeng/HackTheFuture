package com.hackthefuture.Authentication;

/**
 * Created by fengz on 30-Nov-17.
 */

import com.hackthefuture.DAL.models.User;
import com.hackthefuture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Authentication successhandler
 */
public class CustomAuthenticationSuccessHandler extends
        SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    UserRepository userRepository;


    /**
     * Na inloggen, update huidige tijdstamp als lastBezoek
     *
     * @param request        HttpServletRequest
     * @param response       HttpServletResponse
     * @param authentication Authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        super.onAuthenticationSuccess(request, response, authentication);
        //Now add your custom logic to update database
        User user = userRepository.findByUsername(authentication.getName()).get(0);
        user.setLastBezoek(LocalDateTime.now().toString());
        userRepository.save(user);
    }
}
