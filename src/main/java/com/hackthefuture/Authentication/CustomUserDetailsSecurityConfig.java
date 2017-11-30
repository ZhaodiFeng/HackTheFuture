package com.hackthefuture.Authentication;

/**
 * Created by fengz on 30-Nov-17.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

    @EnableWebSecurity
//@Profile("customuserdetails")
    public class CustomUserDetailsSecurityConfig extends WebSecurityConfigurerAdapter {
        /**
         * Get authenticationSuccessHandler
         *
         * @return CustomAuthenticationSuccessHandler
         */
        @Bean
        public CustomAuthenticationSuccessHandler successHandler() {
            return new CustomAuthenticationSuccessHandler();
        }

        /**
         * Get authentication usertailsService
         *
         * @return UserDetailsService
         */
        @Bean
        public UserDetailsService mongoUserDetails() {
            return new CustomerUserDetailsService();
        }

        /**
         * Get BCryptPasswordEncoder als passwordEncoder
         *
         * @return PasswordEncoder
         */
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        /**
         * DaoAuthenticationProvider
         *
         * @return authProvider
         */
        @Bean
        public DaoAuthenticationProvider authProvider() {
            DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
            authProvider.setUserDetailsService(mongoUserDetails());
            authProvider.setPasswordEncoder(passwordEncoder());
            return authProvider;
        }

        /**
         * Set AuthenticationManagerBuilder
         *
         * @param auth AuthenticationManagerBuilder
         * @throws Exception
         */
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(authProvider());
        }

        /**
         * HttpSecurity configuration.     *
         *
         * @param http
         * @throws Exception
         */
        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/css/**", "/img/**", "/images/**", "/js/**", "/pdfs/**").permitAll()
                    .antMatchers("/admin/**").hasAuthority("admin")
                    .antMatchers("/login").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .successHandler(successHandler())
                    .failureUrl("/login?error=true")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout=true");
        }
    }

