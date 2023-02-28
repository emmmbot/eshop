<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
/**
 * my_click和my_blur均是用于前台页面搜索框的函数
 */
//鼠标点击搜索框时执行
function my_click(obj, myid){
	//点击时，如果取得的值和搜索框默认value值相同，则将搜索框清空
	if (document.getElementById(myid).value == document.getElementById(myid).defaultValue){
	  document.getElementById(myid).value = '';
	  obj.style.color='#000';
	}
}
//鼠标不聚焦在搜索框时执行
function my_blur(obj, myid){
	//鼠标失焦时，如果搜索框没有输入值，则用搜索框的默认value值填充
	if (document.getElementById(myid).value == ''){
	 document.getElementById(myid).value = document.getElementById(myid).defaultValue;
	 obj.style.color='#999';
 }
}

/**
 * 点击搜索按钮执行的函数
 */
function search(){
	document.getElementById("searchform").submit();
}
</script>
<div id="divmenu">
		<a href="${pageContext.request.contextPath}/showProductByPage?category=母婴">母婴</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=数码">数码</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=图书">图书</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=食品">食品</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=箱包">箱包</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=进口">进口</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=男装">男装</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=女装">女装</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=童装">童装</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=电器">电器</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=洗护">洗护</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=医药">医药</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=运动">运动</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=保健">保健</a>
		<a href="${pageContext.request.contextPath}/showProductByPage" style="color:#b4d76d">全部商品目录</a>		
</div>
<div id="divsearch">
<form action="${pageContext.request.contextPath }/MenuSearchServlet" id="searchform">
	<table width="100%" border="0" cellspacing="0">
		<tr>
			<td style="text-align:right; padding-right:220px">
				Search 
				<input type="text" name="textfield" class="inputtable" id="textfield" value="请输入商品名"
				onmouseover="this.focus();"
				onclick="my_click(this, 'textfield');"
				onBlur="my_blur(this, 'textfield');"/> 
				<a href="#">
					<img src="${pageContext.request.contextPath}/client/images/serchbutton.gif" border="0" style="margin-bottom:-4px" onclick="search()"/> 
				</a>
			</td>
		</tr>
	</table>
</form>
</div>