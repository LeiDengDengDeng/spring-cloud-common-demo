package com.example.demo.service;

import com.example.demo.bean.Response;
import com.example.demo.util.ResponseFactory;
import org.springframework.stereotype.Component;

/**
 * @author deng
 * @date 2019/03/13
 */
@Component
public class TwoApiFallback implements TwoApi {
    @Override
    public Response<String> getName() {
        return ResponseFactory.okResponse( "二号的替代品");
    }
}
