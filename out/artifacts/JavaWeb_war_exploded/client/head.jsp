<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.eshop.domain.User"%>
<script type="text/javascript">
	//退出确认框
	function confirm_logout() {
		var msg = "您确定要退出登录吗？";
		if (confirm(msg)==true){
			return true;
		}else{
			return false;
		}
	}
</script>
<div id="divhead">
	<table cellspacing="0" class="headtable">
		<tr>
			<td>
				<a href="${pageContext.request.contextPath }/index.jsp">
					<img src="${pageContext.request.contextPath}/client/images/logo.png" width="200" height="60" border="0" />
				</a>
			</td>
			<td style="text-align:right">
				<%
					User user = (User) request.getSession().getAttribute("user");
					if(null == user){
				%>
				<a href="${pageContext.request.contextPath}/client/login.jsp">请登录</a>
				| <a href="${pageContext.request.contextPath}/client/register.jsp">免费注册</a>
				<%
				}else{
				%>
				<img src="${pageContext.request.contextPath}/client/images/cart.gif" width="26" height="23" style="margin-bottom:-4px" />
				&nbsp;
				<a href="${pageContext.request.contextPath}/client/cart.jsp">购物车</a>
				| <a href="${pageContext.request.contextPath}/myAccount">我的帐户</a>
				| <a href="${pageContext.request.contextPath}/logout" onclick="javascript:return confirm_logout()">用户退出</a>
				<br><br><br>欢迎!  ${user.username}
				<%
					}
				%>
			</td>
		</tr>
	</table>
</div>