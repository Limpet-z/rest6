package com.main.rest6.security;

import com.main.rest6.model.XUser;
import com.main.rest6.repository.UserRepositoryJPA;
import com.main.rest6.security.jwt.JwtUser;
import com.main.rest6.security.jwt.JwtUserFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepositoryJPA userService;

    @Autowired
    public JwtUserDetailsService(UserRepositoryJPA userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        XUser user = userService.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User with email: " + email + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN findByEmail - user with email: {} successfully loaded", email);
        return jwtUser;
    }
}
