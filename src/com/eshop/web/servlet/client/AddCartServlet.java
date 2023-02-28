package com.eshop.web.servlet.client;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.eshop.domain.Product;
import com.eshop.exception.FindProductByIdException;
import com.eshop.service.ProductService;

@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// 调用service层方法，根据id查找商品
		ProductService service = new ProductService();
		try {
			Product p = service.findProductById(id);
			HttpSession session = request.getSession();
			//尝试从session中获取购物车对象
			Map<Product, Integer> cart = (Map<Product, Integer>)session.getAttribute("cart");
			//没有购物车则创建购物车
			if (cart == null) {
				cart = new HashMap<Product, Integer>();
			}
			//向购物车中添加商品。如果商品存在，则数量值发生替换，count为原数量。否则count为null
			Integer count = cart.put(p, 1);
			//如果原数量不为空，则商品数量更新为原数量+1
			if (count != null) {
				cart.put(p, count + 1);
			}			
			session.setAttribute("cart", cart);
			response.sendRedirect(request.getContextPath() + "/client/cart.jsp");
			return;
		} catch (FindProductByIdException e) {
			e.printStackTrace();
		}
	}
}
