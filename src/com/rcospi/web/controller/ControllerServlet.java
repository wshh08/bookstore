package com.rcospi.web.controller;

import com.rcospi.domain.Category;
import com.rcospi.service.BusinessService;
import com.rcospi.service.impl.BusinessServiceImpl;
import com.rcospi.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wshh08 on 16-11-20.
 */
@WebServlet(name = "ControllerServlet", urlPatterns = "/servlet/ControllerServlet")
public class ControllerServlet extends HttpServlet {

    private BusinessService s = new BusinessServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
        String op = request.getParameter("op");
        if ("addCategory".equals(op)) {
            addCategory(request);
            response.getWriter().write("<script>alert('添加成功')</script>");
            response.setHeader("Refresh", "1;URL=" + request.getContextPath() + "/manage/addCategory.jsp");
            // 重定向，防止表单重复提交
//            response.sendRedirect(request.getContextPath() + "/manage/addCategory.jsp");
        }
    }

    // 根据request post过来的参数完成新分类的添加操作(封装数据,模型填充、利用BeanUtils写了个WebUtil工具类)
    private void addCategory(HttpServletRequest request) {
        // 封装数据
        Category category = WebUtil.fillBean(request, Category.class);
        // 调用业务方法
        s.addCategory(category);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
