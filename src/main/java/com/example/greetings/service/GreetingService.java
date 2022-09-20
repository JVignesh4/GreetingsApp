package com.example.greetings.service;


import com.example.greetings.model.Greeting;
import com.example.greetings.model.User;
import com.example.greetings.repository.GreetingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService implements IGreetingService {
    public String getMessage() {
        return "Hello Vignesh";
    }

    public String messageByName(String firstname, String lastname) {
        return "Hello " + firstname + " " + lastname ;
    }

    @Autowired
    private GreetingsRepository greetingsRepository;

    public User saveRepo(User user){
        User newUser = new User(user);
        greetingsRepository.save(newUser);
        return newUser;
    }
    public String saveRepoHello(User user) {
        User newUser = new User(user);
        return "Hello "+ newUser;
    }

    public Optional<Greeting> getById(long id) {
        return greetingsRepository.findById(id);

    }

    public List<Greeting> listAll(){
        return greetingsRepository.findAll();

    }

    public String deleteById(long id) {
        greetingsRepository.deleteById(id);
        return "User by id "+id+" is Deleted";
    }
}
