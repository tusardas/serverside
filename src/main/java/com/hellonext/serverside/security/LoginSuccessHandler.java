package com.hellonext.serverside.security;

import java.io.IOException;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler  {
    Logger log = LoggerFactory.getLogger(LoginSuccessHandler.class);
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        Set<String> roleIds = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        log.info("roleIds ------------------------------> " + roleIds);
        if(roleIds.contains("2")) {
            response.sendRedirect("/admin");
        }
        else if(roleIds.contains("1")) {
            response.sendRedirect("/");
        }
    }
    
}
