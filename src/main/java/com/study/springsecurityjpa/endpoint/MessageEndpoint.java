package com.study.springsecurityjpa.endpoint;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MessageEndpoint {

    @GetMapping
    String everyone() {
        return "everyone";
    }

    @GetMapping("user")
    @Secured("ROLE_USER")
    String user() {
        return "user";
    }

    @GetMapping("admin")
    @Secured("ROLE_ADMIN")
    String admin() {
        return "admin";
    }
}
