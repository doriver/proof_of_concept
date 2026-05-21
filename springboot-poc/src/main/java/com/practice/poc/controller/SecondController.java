package com.practice.poc.controller;

import com.practice.poc.controller.service.AsyncService;
import com.practice.poc.dto.mybatis.UserM;
import com.practice.poc.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SecondController {
    private final AsyncService asyncService;
    private final PersonMapper personMapper;

    @GetMapping("/async")
    public String startAsync() {
        // 비동기 작업을 호출하고 즉시 리턴
        asyncService.doLongTask();
        // 필요하다면 future.join() 등을 통해 결과를 동기적으로 받을 수도 있지만, 여기서는 비동기 수행만 확인하고 바로 응답.
        return "비동기 작업이 시작되었습니다!";
    }

    @GetMapping("/mybatis")
    public  Map<Long, String> asdf() {
        List<UserM> all = personMapper.findAll();

        Map<Long, String> m = new HashMap<>();
        for (int i = 0; i < all.size(); i++) {
            UserM user = all.get(i);
            m.put(user.getId(), user.getName());
        }
        return m;
    }
}
