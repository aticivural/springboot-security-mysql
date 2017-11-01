package com.vural.security.springbootsecuritymysql.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CORSController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @CrossOrigin(origins = "http://localhost:9090")
    @GetMapping("/greeting")
    @ResponseBody
    public Greeting greeting(@RequestParam(required=false, defaultValue="World") String name, HttpServletRequest request) {
        System.out.println(request.getRequestURL());
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteHost());
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}


class Greeting {

    private final long id;
    private final String content;

    public Greeting() {
        this.id = -1;
        this.content = "";
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}