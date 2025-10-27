package com.practice.poc.controller.service;

import com.practice.poc.domain.model.Person;
import com.practice.poc.domain.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FirstService {

    private final PersonRepository personRepository;

    public Map<Long, String> firstConnect() {
        Person person = new Person("재석");
        personRepository.save(person);
        Optional<Person> first = personRepository.findById(1L);
        Person firstPerson = first.get();

        Map<Long, String> map = new HashMap<>();
        map.put(firstPerson.getId(), firstPerson.getName());
        return map;
    }

    public String method() {
        return "의존성 주입";
    }
}
