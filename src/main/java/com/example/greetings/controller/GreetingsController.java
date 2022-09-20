package com.example.greetings.controller;


import com.example.greetings.model.Greeting;
import com.example.greetings.model.User;
import com.example.greetings.service.GreetingService;
import com.example.greetings.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {

    private static final String template = "Hello, %s !";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    @GetMapping("/msg")
    public String getMessage() {
        return greetingService.getMessage();
    }

    @GetMapping("/msgbyname/{firstname}/{lastname}")
    public String getByNameParam(@PathVariable String firstname, @PathVariable String lastname) {
        return greetingService.messageByName(firstname, lastname);
    }


    @PostMapping("/post")
    public User saveRepo(@RequestBody User user) {
        User newUser = greetingService.saveRepo(user);
        return newUser;
    }

    @GetMapping("/get/{id}")
    public Optional<Greeting> getById(@PathVariable int id) {
        Optional<Greeting> response = greetingService.getById(id);
        return response;
    }

    @GetMapping("/users")
    public List<Greeting> listOfAll() {
        List<Greeting> response = greetingService.listAll();
        return response;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        String response = greetingService.deleteById(id);
        return response;
    }

}
