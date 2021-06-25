package com.example.demo.module.pay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payController")
public class PayController {


    @RequestMapping("/get")
    @ResponseBody
    public String get() {
        System.out.println("http://localhost:8080/payController/get");
        return "金钱";
    }
}
