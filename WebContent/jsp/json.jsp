<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${applicationScope.path }">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$("button").click(function() {
			$.ajax({url:"jsonTest",type: "post",success: function(data) {
// 				var jsondata = eval("("+data+")");
				var jsondata = JSON.parse(data);
				$("table").html("");
				$.each(jsondata, function(i, obj) {
					$("table").append($("<tr><td>"+i+"</td><td>"+obj.userid+"</td><td>"+obj.uname+"</td><td>"+obj.udate+"</td>"+"</tr>"));
				});
				$("div").show(1000);
			},error: function(err) {
				alert(err.statusText+"---"+err.status);
			}});
// 			$.post("jsonTest",function(data){
// 				var jsondata = eval("("+data+")");
// 				$("table").html("");
// 				$.each(jsondata, function(i, obj) {
// 					$("table").append($("<tr><td>"+obj.userid+"</td><td>"+obj.uname+"</td><td>"+obj.udate+"</td>"+"</tr>"));
// 				});
// 				$("div").show(1000);
// 			});
// 			$.get("jsonTest",function(data){
// 				var jsondata = eval("("+data+")");
// 				$("table").html("");
// 				$.each(jsondata, function(i, obj) {
// 					$("table").append($("<tr><td>"+obj.userid+"</td><td>"+obj.uname+"</td><td>"+obj.udate+"</td>"+"</tr>"));
// 				});
// 				$("div").show(1000);
// 			});
		});
	});
</script>
<body>
	<button>查询用户信息</button>
	<div style="display: none;">
		<table style="width: 500px;text-align: center;"></table>
	</div>
</body>
</html>