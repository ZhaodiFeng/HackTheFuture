package com.hackthefuture.Authentication;

/**
 * Created by fengz on 30-Nov-17.
 */

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class MongoUserDetails implements UserDetails {
    public String username;
    public String password;
    public List<GrantedAuthority> grantedAuthorities;

    public MongoUserDetails(String username, String password, String[] authorities) {
        this.username = username;
        this.password = password;
        this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
    }

    /*
     *@return Authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    /**
     * @return hashed password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * @return username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * @return isAccountNonExpired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return isAccountNonLocked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
