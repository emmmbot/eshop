package com.eshop.web.servlet.manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshop.dao.UserDao;
import com.eshop.domain.Order;
import com.eshop.domain.User;
import com.eshop.exception.ActiveUserException;
import com.eshop.exception.RegisterException;
import com.eshop.service.OrderService;
import com.eshop.service.UserService;
import com.eshop.utils.MailUtils;
@WebServlet("/confirmDeliver")

public class ConfirmDeliverServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String trackingnum = request.getParameter("trackingnum");
        OrderService service = new OrderService();
        try {
            service.confirmDdeliver(id,trackingnum);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/findOrders");
        //request.getRequestDispatcher("/findOrders").forward(request,response);
    }

}
