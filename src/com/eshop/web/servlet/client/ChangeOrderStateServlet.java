package com.eshop.web.servlet.client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshop.domain.User;
import com.eshop.utils.MailUtils;
import com.eshop.service.OrderService;

@WebServlet("/orderstate")
public class ChangeOrderStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 获得订单号数据
		String orderid = request.getParameter("orderid");
		String paySuccess = "恭喜您支付成功！";
		if (null != orderid) {
				OrderService service = new OrderService();
				// 根据订单号修改订单状态
				try {
					service.updateState(orderid);
					request.setAttribute("paySuccess", paySuccess);
					String emailMsg = "感谢您的购买，您的订单编号为"+orderid
							+ "<br />点击<a href='http://127.0.0.1:8080/findOrderById?id="
							+ orderid + "'>&nbsp;此处&nbsp;</a>查看。";
					User user = (User) request.getSession().getAttribute("user");
					MailUtils.sendMail(user.getEmail(), "感谢您在eshop的购买",emailMsg);
					request.getRequestDispatcher("/findOrderByUser").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					response.getWriter().write("修改订单状态失败");
				}
			}
	}
}
