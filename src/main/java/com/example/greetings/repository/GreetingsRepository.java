package com.example.greetings.repository;

import com.example.greetings.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingsRepository extends JpaRepository<Greeting,Long> {

}
