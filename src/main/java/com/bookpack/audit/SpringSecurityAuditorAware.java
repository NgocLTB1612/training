package com.bookpack.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<String> {



    public Optional<String> getCurrentAuditor() {



        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();



        if (authentication == null || !authentication.isAuthenticated()) {

            return null;

        }
        String username = "";
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else {
            username = principal.toString();
        }
        return Optional.of(username);

    }

}