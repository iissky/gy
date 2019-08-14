<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE>
<html>
<head>
<base href="${applicationScope.path }">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function del(id){
		if(confirm("是否确认删除？")){
			window.location.href="user?type=del&id="+id;
		}
	}
	
	function update(id,uname,upwd,uphone,udate,usex,ustatus){
		var tr = document.getElementById('row'+id);
		tr.innerHTML="<td>"+id+"<input type='hidden' name='id' value='"+id+"'/></td><td><input name='uname' value='"+uname+"'/></td><td><input name='upwd' value='"+upwd+"'/></td><td><input name='uphone' value='"+uphone+"'/></td><td><input name='udate' value='"+udate+"'/></td><td><input name='usex' value='"+usex+"'/></td><td><input name='ustatus' value='"+ustatus+"'/></td><td><input type='submit' value='确定'/></td>";
	}
	
	function mysubmit(){
		document.getElementById("myform").submit();
	}
</script>
<body>
	欢迎${user}登陆成功,您是第${applicationScope.count }位登陆我们网站的会员。
	<a href="exit">退出登录</a>
	<div style="margin: 0 auto;">
	<a href="user?type=query">查询数据</a>
	<a href="user?type=querybypage">分页查询数据</a>
	<a href="jsp/register.jsp">注册</a>
	<a href="jsp/json.jsp">json测试页面</a>
	<form id='myform' action='user?type=update' method='post'>
		<table>
			<tr>
				<th>id</th>
				<th>用户名</th>
				<th>密码</th>
				<th>电话</th>
				<th>生日</th>
				<th>性别</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
			
			<c:forEach items="${pb.list }" var="user">
				<tr id="row${user.userid }">
					<td>${user.userid }</td>
					<td>${user.uname }</td>
					<td>${user.upwd }</td>
					<td>${user.uphone }</td>
					<td><fmt:formatDate value="${user.udate }" pattern="yyyy-MM-dd"/></td>
					<td><c:if test="${user.usex=='1'}">男</c:if>
					<c:if test="${user.usex=='2'}">女</c:if> </td>
					<td>${user.ustatus }</td>
					<td><a href="javascript:del('${user.userid }')">删除</a> 
					<a href="javascript:update('${user.userid }','${user.uname }','${user.upwd }','${user.uphone }','${user.udate }','${user.usex}','${user.ustatus }')">修改</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">
					<A href="user?type=querybypage">首页</A>
					<c:if test="${pb.pageindex>1}">
						<a href="user?type=querybypage&pageindex=${pb.pageindex-1 }">上一页</a>
					</c:if>
					当前第${pb.pageindex }页
					<c:if test="${pb.pageindex<pb.pagemax}">
						<a href="user?type=querybypage&pageindex=${pb.pageindex+1 }">下一页</a>
					</c:if>
					<a href="user?type=querybypage&pageindex=${pb.pagemax }">末页</a>
					总页数：${pb.pagemax }
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>