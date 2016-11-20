package com.rcospi.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

/**
 * Created by wshh08 on 16-11-20.
 */
public class SetAllCharacterEncodingFilter implements javax.servlet.Filter {

    private FilterConfig config;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        String encoding = "UTF-8";
        String value = config.getInitParameter("encoding");

        HttpServletRequest request;
        HttpServletResponse response;
        try {
            request = (HttpServletRequest) req;
            response = (HttpServletResponse) resp;
        } catch (Exception e) {
            throw new RuntimeException("No-http request!");
        }

        if (value != null && !Objects.equals(encoding, value)) {
            encoding = value;
        }

        // 设置请求(request/response)&响应编码
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);    //方便其他过滤器可以根据response获取编码信息
        response.setContentType("text/html;charset=" + encoding);

        // 解决GET请求乱码需要对request进行包装
        MyHttpServletRequest MyRequest = new MyHttpServletRequest(request);
        chain.doFilter(MyRequest, response);
    }


    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    private class MyHttpServletRequest extends HttpServletRequestWrapper {

        public MyHttpServletRequest(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            if (value == null)
                return null;
            String method = super.getMethod();
            if ("get".equalsIgnoreCase(method)) {
                try {
                    return new String(value.getBytes("UTF-8"), super.getCharacterEncoding());
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
            return value;
        }
    }
}













