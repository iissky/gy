<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${applicationScope.path }">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<%
	String error = request.getParameter("error");
	String mess = "";
	if("true".equals(error)){
		mess = "用户名密码错误";
	}
	
	//获取页面端传递来的cookie
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(int i=0;i<cookies.length;i++){
			if("username".equals(cookies[i].getName())){
				String username = cookies[i].getValue();
				if(username!=null&&!"".equals(username)){//跳转到成功页面
					session.setAttribute("user", username);
					response.sendRedirect("jsp/xinhua.jsp");
				}
			}
		}
	}
%>
<body>
	欢迎登陆新华官网
	<form action="login" method="post">
		用户名<input name="username"><br>
		密码<input type="password" name="pwd"><%=mess %><br>
		是否记住密码：<input type="checkbox" value="true" name="isRember"><br>
		<input type="submit" value="登陆">
	</form>
</body>
</html>