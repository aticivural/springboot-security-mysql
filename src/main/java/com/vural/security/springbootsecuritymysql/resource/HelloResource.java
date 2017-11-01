package com.vural.security.springbootsecuritymysql.resource;


import com.vural.security.springbootsecuritymysql.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/hello")
@RestController
public class HelloResource {

    @GetMapping("/all")
    public String hello() {
        return "Hello Youtube";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedHello(final Authentication authentication) {
        System.out.println(authentication.getName());
        System.out.println(authentication.getAuthorities());
        System.out.println(authentication.getCredentials());
        System.out.println(authentication.getPrincipal());
        User loggedUser = (User) authentication.getPrincipal();
        System.out.println("NAME => " + loggedUser.getName() + " PASSWORD => " + loggedUser.getPassword());
        System.out.println(authentication.isAuthenticated());
        return "Secured Hello";
    }

    @GetMapping("/secured/alternate")
    public String alternate() {
        return "alternate";
    }

    @GetMapping(value = "/test")
    public String test(){
        return "secured test";
    }
}