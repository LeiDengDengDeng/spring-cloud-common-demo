package com.example.demo.controller;

import com.example.demo.bean.Response;
import com.example.demo.service.TwoApi;
import com.example.demo.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author deng
 * @date 2019/03/13
 */
@RestController
@RequestMapping("/api/v1/one")
public class OneController {
    @Autowired
    private TwoApi twoApi;

    @GetMapping("/test")
    public Response<String> get() {
        return ResponseFactory.okResponse("你好");
    }

    @GetMapping("/sayHi")
    public String sayHi() {
        return "Hello," + twoApi.getName().getRes();
    }
}
