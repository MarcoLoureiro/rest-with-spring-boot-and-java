package br.com.rest_with_spring_boot_and_java.controllers;

import br.com.rest_with_spring_boot_and_java.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController("/api")
public class GreetingController {
    private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Hello World") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
}
