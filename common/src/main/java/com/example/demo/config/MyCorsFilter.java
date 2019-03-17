package com.example.demo.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)//放在过滤器链的最前面
public class MyCorsFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        // 获取origin字段
        String origin = httpServletRequest.getHeader("origin");

        if (!StringUtils.isEmpty(origin)) {
            // 允许跨域问题
            httpServletResponse
                    .addHeader("Access-Control-Allow-Origin", origin);
        }

        // 允许的方法
        httpServletResponse
                .addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");

        // 获取自定义请求头
        String headers = httpServletRequest
                .getHeader("Access-Control-Request-Headers");

        if (!StringUtils.isEmpty(headers)) {
            // 自定义请求头允许
            httpServletResponse.addHeader("Access-Control-Allow-Headers",
                    headers);
        }

        // cookie跨域问题解决
        httpServletResponse.addHeader("Access-Control-Allow-Credentials",
                "true");

        httpServletResponse.addHeader("Access-Control-Max-Age","3600");

        //某些请求先发送OPTIONS，再发送真正的请求，对所有OPTIONS请求统统放行
        if("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
