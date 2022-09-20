package com.example.greetings.service;

import com.example.greetings.model.Greeting;
import com.example.greetings.model.User;

import java.util.List;
import java.util.Optional;

public interface IGreetingService {

    public User saveRepo(User user);
    public Optional<Greeting> getById(long id);
    public List<Greeting> listAll();
    public String deleteById(long id);
    public String getMessage();
    public String messageByName(String firstname, String lastname);

}
