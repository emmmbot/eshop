package com.eshop.web.servlet.client;
import java.io.IOException;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eshop.domain.User;
import com.eshop.service.UserService;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户输入的用户名与密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 调用service层方法验证用户是否合法
		UserService service = new UserService();
		try {
			User user = service.login(username, password);
			
			// 将用户存储到session中
			request.getSession().setAttribute("user", user);
			// 获取用户的身份
			String role = user.getRole();
			// 如果是管理员，将页面跳转至后台管理系统；否则进入我的账户页面
			if ("1".equals(role)) {
				response.sendRedirect(request.getContextPath() + "/admin/login/home.jsp");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/client/myAccount.jsp");
				return;
			}
		} catch (LoginException e) {
			// 如果出现问题，将错误信息存储到request范围，并跳转回登录页面显示错误信息
			e.printStackTrace();
			request.setAttribute("register_message", e.getMessage());
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}
	}
}
