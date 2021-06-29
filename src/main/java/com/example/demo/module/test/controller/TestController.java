package com.example.demo.module.test.controller;

import com.example.demo.module.test.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by LiuXF on 2021/04/29 10:19:15
 */
@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/get")
    public String get(String name) {
        return testService.serviceGet(name);
    }
}
