package com.practice.poc.controller.service;

import org.springframework.stereotype.Service;

@Service
public class FirstService {
    public String method() {
        return "의존성 주입";
    }
}
