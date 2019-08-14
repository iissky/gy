<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${applicationScope.path }">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	var xmlhttp;
	function checkName(name){
		//1.创建XMLHttpRequest对象
		if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
			 xmlhttp=new XMLHttpRequest();
		}else{// code for IE6, IE5
			 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		//指定回调函数
		xmlhttp.onreadystatechange=reback;
		//打开连接 指定提交方式，指定url地址  指定是否异步（true为异步 false同步）
		//js中向后台传中文参数需要转码encodeURI('张三')
		xmlhttp.open("post","checkName?name="+encodeURI(name),true);
		//设置传参方式为表单提交
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		//发送请求
		xmlhttp.send();
	}
	
	function reback(){
		//xmlhttp.readyState状态是请求发送的完成状态   xmlhttp.status是页面响应正常的状态
		var mess = document.getElementById("mess");
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			console.log(xmlhttp.responseText);
			if(xmlhttp.responseText=="yes"){ //重复
				mess.style.color = "red";
				mess.innerHTML="用户名已被占用";
			}else{//可用
				mess.style.color = "green";
				mess.innerHTML="用户名可用";
			}
		}
	}
</script>
<body>
	<div align="center">
		<h1>欢迎注册</h1>
		<form action="">
			<p>用户名:<input name="username" onblur="checkName(this.value)"/><span id="mess"></span></p>
			<p>密码:<input name="pwd"/></p>
			<p><input type="submit" value="注册"/></p>
		</form>
	</div>
</body>
</html>