package com.example.demo.controller;

import com.example.demo.bean.Response;
import com.example.demo.util.ResponseFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author deng
 * @date 2019/03/13
 */
@RestController
@RequestMapping("/api/v1/two")
public class TwoController {
    @GetMapping("/getName")
    public Response<String> getName() {
        return ResponseFactory.okResponse("二号后端");
    }
}
