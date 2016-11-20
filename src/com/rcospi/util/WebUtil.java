package com.rcospi.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 利用BeanUtils根据请求封装JavaBean的工具类
 */
public class WebUtil {
    public static <T> T fillBean(HttpServletRequest request, Class<T> clazz) {
        try {
            T bean = clazz.newInstance();
            BeanUtils.populate(bean, request.getParameterMap());
            return bean;
        } catch (Exception e) {
            throw new RuntimeException("封装JavaBean失败");
        }
    }
}
