<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>连锁店报表系统</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome/style.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animate.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js" ></script>
		<script>
			$(function(){
				$('#account,#password').focus(function(){
					$('#container').removeClass("animated tada fadeInDown");
					$('.msg').html("");
				});
				$('form').submit(function(){
			        var account  = $('#account').val();
					var password = $('#password').val();
					//改变登录按钮文字
					$('#submit').val('登录...');
					//让ajax变为同步方式
					$.ajaxSetup({async:false});
					$.post('${pageContext.request.contextPath}/user/login', $('form').serialize(), function(result) {
						if (result) {
							window.location.href='${pageContext.request.contextPath}/index.jsp';
						} else {
							$('#submit').val('登录');
							$('#container').removeClass("animated tada fadeInDown").addClass('animated tada');
							$('.msg').html("用户名或密码错误！");
						}
					});
					return false;
				});
			});
		</script>
	</head>

	<body>
		<div class="loginbox pop_fadein animated fadeInDown" id="container">
			<div class="title">
				<div class="logo"><b>CRS</b>连锁店报表系统</div>
				<div class='info'>—— V1.0</div>
			</div>
			<form method="post">
				<div class="inputs">
					<div>
						<span><i class="icon-user"></i></span>
						<input id="account" name='account' type="text" placeholder="账号" required/> 
					</div>
					<div>
						<span><i class="icon-lock"></i></span>
						<input id="password" name='password' type="password" placeholder="密码" required />
					</div>
				</div>
				<div class="actions">
					<input type="submit" id="submit" value="登录" />
				</div>
				<div class="msg"></div>
				<div style="clear:both;"></div>
				<div class='guest'>
					<a href="${pageContext.request.contextPath}/index.jsp">返回首页<i class='icon-arrow-right'></i></a>
				</div>
			</form>
		</div>
		<a href=""></a>
	</body>

</html>