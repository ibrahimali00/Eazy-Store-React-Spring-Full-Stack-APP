package com.eazybytes.eazybytes.config;

import com.eazybytes.eazybytes.entity.Customer;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("AuditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication aut = SecurityContextHolder.getContext().getAuthentication();
        if (aut == null || !aut.isAuthenticated() || aut.getPrincipal().equals("anonymousUser")) {
            return Optional.of("Anonymous User");
        }

        Object principal = aut.getPrincipal();
        String username;

        if (principal instanceof Customer customer) {
            username = customer.getName();
        }else {
            username  = principal.toString();
        }
        return Optional.of(username);
    }
}
