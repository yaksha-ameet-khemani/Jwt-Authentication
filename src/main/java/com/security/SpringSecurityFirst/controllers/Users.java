package com.security.SpringSecurityFirst.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.web.csrf.*;

@RestController
@RequestMapping("/users")
public class Users {

    @GetMapping("token")
    public CsrfToken getToken(HttpServletRequest req) {
        return (CsrfToken) req.getAttribute("_csrf");
    }

    @GetMapping
    public String helloAll(HttpServletRequest req) {
        return "hello world" + req.getRequestedSessionId() + " /n" + ((CsrfToken) req.getAttribute("_csrf")).getToken();
    }

    @PostMapping
    public void postRequest() {
        System.out.println("post request completed");
    }
}
