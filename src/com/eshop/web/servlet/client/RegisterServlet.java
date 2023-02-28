package com.eshop.web.servlet.client;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshop.utils.ActiveCodeUtils;
import org.apache.commons.beanutils.BeanUtils;
import com.eshop.domain.User;
import com.eshop.exception.RegisterException;
import com.eshop.service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 将表单提交的数据封装到javaBean
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            // 封裝激活码
            user.setActiveCode(ActiveCodeUtils.createActiveCode());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        // 调用service层方法
        UserService service = new UserService();
        try {
            service.register(user);
        } catch (RegisterException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
            return;
        }
        // 跳转到注册成功页面
        response.sendRedirect(request.getContextPath() + "/client/registersuccess.jsp");
    }
}
