package com.practice.poc.controller;

import com.practice.poc.controller.service.FirstService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class FirstController {

    private final FirstService service;

    @ResponseBody
    @RequestMapping("/first")
    public String hello() {
        return "hello world";
    }

    @ResponseBody
    @RequestMapping("/service")
    public String firestService() {
        return service.method();
    }

    @ResponseBody
    @RequestMapping("/first/db")
    public Map<Long, String> firestRepo() {
        return service.firstConnect();
    }
}
