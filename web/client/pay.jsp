<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="p" uri="http://www.itcast.cn/tag"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>在线支付</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<p:user/>
	<form action="${pageContext.request.contextPath}/pay?orderid=${param.id}&money=${param.money}" method="post">
		订单号：${param.id}"
		支付金额：${param.money}"元
		<div class="divBank">
			<div class="divText">请选择支付方式</div>
			<div style="margin-left: 20px;">
				<div style="margin-bottom: 20px;">
					<input id="wechat" type="radio" name="yh" value="wechat" checked="checked" />
					<img name="wechat" align="middle" tyle="width:450px;height:300px;" src="<c:url value='/client/pay_img/wechat.bmp'/>" />
				</div>
				<div style="margin-bottom: 20px;">
					<input id="airpay" type="radio" name="yh" value="airpay" checked="checked" />
					<img name="airpay" align="middle" tyle="width:450px;height:300px;" src="<c:url value='/client/pay_img/airpay.bmp'/>" />
				</div>
				<div style="margin-bottom: 20px;">
					<input id="up" type="radio" name="yh" value="up" checked="checked" />
					<img name="up" align="middle"  tyle="width:450px;height:300px;"src="<c:url value='/client/pay_img/unionpay.bmp'/>" />
				</div>
			</div>
			<div style="margin: 40px;">
				<INPUT TYPE="submit" value="确定支付">
			</div>
		</div>
	</form>
</body>
</html>
