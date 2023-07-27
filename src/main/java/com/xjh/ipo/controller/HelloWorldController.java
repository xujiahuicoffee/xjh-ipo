package com.xjh.ipo.controller;

import com.xjh.ipo.request.HelloWorldRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xujiahui
 * @ClassName helloWorldController
 * @description: TODO
 * @time 2023/7/27 16:35
 */
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    /***
     * 自定义注解和AOP的Demo
     * @param request
     * @return
     */
    @PostMapping("/sayHello")
    public String sayHello(@RequestBody HelloWorldRequest request) {
        return "hello " + request.getCity();
    }


}
