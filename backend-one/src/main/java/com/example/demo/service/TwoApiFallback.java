package com.example.demo.service;

import com.example.demo.bean.Response;
import com.example.demo.util.ResponseFactory;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

/**
 * @author deng
 * @date 2019/03/13
 */
@Component
@CommonsLog
public class TwoApiFallback implements TwoApi {
    @Override
    public Response<String> getName() {
        log.info("Two服务降级");
        return ResponseFactory.okResponse( "二号的替代品");
    }
}
