package com.practice.poc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class RedisTestController {
    /*
       별도의 설정 클래스 없이, Spring Boot가 자동으로 생성해주는 StringRedisTemplate을 주입받아 바로 사용
       ( StringRedisTemplate: Redis의 Key와 Value가 모두 문자열일 때 사용하는 템플릿 )
     */
    private final StringRedisTemplate redisTemplate;

    // 데이터 저장: /set?key=name&value=gemini
    @GetMapping("/set")
    @ResponseBody
    public String setData(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        return "저장 완료!";
    }// opsForValue(): Redis의 가장 기본적인 자료구조인 String 타입을 다루기 위한 메서드 집합

    // 데이터 조회: /get?key=name
    @GetMapping("/get")
    @ResponseBody
    public String getData(@RequestParam String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
