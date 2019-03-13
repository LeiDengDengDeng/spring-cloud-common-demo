package com.example.demo.service;

import com.example.demo.bean.Response;
import com.example.demo.constant.ServiceInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author deng
 * @date 2019/03/13
 */
@FeignClient(value = ServiceInfo.BACKEND_TWO, fallback = TwoApiFallback.class)
public interface TwoApi {
    @GetMapping("/api/v1/two/getName")
    Response<String> getName();
}
