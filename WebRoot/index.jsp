<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="product" content="Metro UI CSS Framework">
    <meta name="description" content="Simple responsive css framework">
    <meta name="author" content="Sergey S. Pimenov, Ukraine, Kiev">

    <link href="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/css/metro-bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/css/metro-bootstrap-responsive.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/css/iconFont.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/css/docs.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/js/prettify/prettify.css" rel="stylesheet">

    <!-- Load JavaScript Libraries -->
    <script src="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/js/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/js/jquery/jquery.widget.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/js/jquery/jquery.mousewheel.js"></script>
    <script src="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/js/prettify/prettify.js"></script>

    <!-- Metro UI CSS JavaScript plugins -->
    <script src="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/js/load-metro.js"></script>

    <!-- Local JavaScript -->
    <script src="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/js/docs.js"></script>
    <!-- <script src="js/Metro-UI-CSS-master/docs/js/github.info.js"></script> -->
    <script src="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/js/start-screen.js"></script>

    <title>连锁店报表系统</title>
    
</head>
<body class="metro">
    <div class="tile-area tile-area-dark">
        <h1 class="tile-area-title fg-white">
        	<span class="icon-grid-view"></span>
        	CRS连锁店报表系统
        </h1>
        <div class="user-id">
        	<!-- 已登录 -->
        	<c:if test="${account != null}">
	            <div class="user-id-image">
	           		<img src="${pageContext.request.contextPath}/images/penguin.png" class="display">
	            </div>
	            <div class="user-id-name">
	                <span class="first-name">[${roleName}]${account}</span>
	            </div>
            </c:if>
            <!-- 未登录 -->
            <c:if test="${account == null}">
	            <a class="user-id-name" style="color:#FFF;" href="${pageContext.request.contextPath}/login.jsp">
	                <span class="first-name">登录&nbsp;<span class="icon-arrow-right"></span></span>
	            </a>
            </c:if>
        </div>

        <div class="tile-group six">
			<div class="tile-group-title">
            	<span class="icon-bars"></span>&nbsp;业务分析
            </div>
            <a class="tile double bg-lightBlue live" data-role="live-tile" data-effect="slideUp" data-click="transform" href="datagrid/datagrid1.jsp?rightsNum=1001">
                <div class="tile-content bg-lightblue">
					<div class="text-right padding10 ntp">
						<h3 class="fg-white text-right padding10">分店营业日对比表</h3>
						<p class="fg-white">Day Contract</p>
					</div>
				</div>

				<div class="brand">
					<div class="label">
						<h3 class="no-margin fg-white">
							<span class="icon-calendar"></span>
						</h3>
					</div>
				</div>

            </a> <!-- end tile -->

            <a class="tile double bg-violet" data-click="transform" href="datagrid/datagrid2.jsp">
                <div class="tile-content">
					<div class="text-right padding10 ntp">
						<h3 class="fg-white text-right padding10">分店营业月对比表</h3>
						<p class="fg-white">Month Contract</p>
					</div>
				</div>
				<div class="brand">
					<div class="label">
						<h3 class="no-margin fg-white">
							<span class="icon-calendar"></span>
						</h3>
					</div>
				</div>
            </a> <!-- end tile -->

            <a class="tile double bg-darkOrange" data-click="transform" href="datagrid/datagrid3.jsp">
                <div class="tile-content">
					<div class="text-right padding10 ntp">
						<h3 class="fg-white text-right padding10">营业时段分析表</h3>
						<p class="fg-white">Opening Analysis</p>
					</div>
				</div>
				<div class="brand">
					<div class="label">
						<h3 class="no-margin fg-white">
							<span class="icon-calendar"></span>
						</h3>
					</div>
				</div>
            </a> <!-- end tile -->

            <a class="tile double double-vertical bg-darkPink" data-click="transform" href="reports/hourkll.jsp">
                <div class="tile-content icon" >
                	<span class="icon-stats-up"></span>
                    <div class="padding10">
						<h4 class="fg-white padding10 ntm">本店客流量对比分析</h4>
						</br>
					</div>
                </div>
            </a> <!-- end tile -->
			<a class="tile double bg-darkGreen" data-click="transform" href="reports/yye.jsp">
                <div class="tile-content icon">
                    <span class="icon-stats-up"></span>
                </div>
                <div class="brand">
                    <div class="label">本店营业额对比分析</div>
                </div>
            </a>

            <a class="tile double bg-teal" data-click="transform" href="reports/xfd.jsp">
                <div class="tile-content icon">
                    <span class="icon-bars"></span>
                </div>
                <div class="brand">
                    <div class="label">本店消费单对比分析</div>
                </div>
            </a>

            <a class="tile double bg-lightBlue" data-click="transform" href="reports/hyxf.jsp">
                <div class="tile-content icon">
                    <span class="icon-bars"></span>
                </div>
                <div class="brand">
                    <div class="label">本店会员消费对比分析</div>
                </div>
            </a>

            <a class="tile double bg-amber" data-click="transform" href="reports/daykll.jsp">
                <div class="tile-content icon">
                    <span class="icon-stats-up"></span>
                </div>
                <div class="brand">
                    <div class="label">分店客流量对比分析</div>
                </div>
            </a>
        </div> <!-- End group -->

        <div class="tile-group one">
            
        </div> <!-- End tile group -->
		<c:if test="${account != null}">
        <div class="tile-group double">
            <div class="tile-group-title">
            	<span class="icon-tools"></span>设置
            </div>
            <a class="tile bg-green" id="editPassword">
                <div class="tile-content icon">
                	<span class="icon-pencil"></span>
                </div>
                <div class="brand">
                    <div class="label">修改密码</div>
                </div>
            </a>
            <a class="tile bg-red" data-click="transform" href="${pageContext.request.contextPath}/user/logout">
                <div class="tile-content icon">
					<span class="icon-exit"></span>
                </div>
                <div class="brand">
                    <div class="label">退出系统</div>
                </div>
            </a>
            <a class="tile bg-olive" id="about">
                <div class="tile-content icon">
                    <span class="icon-bookmark"></span>
                </div>
                <div class="brand">
                    <div class="label">关于</div>
                </div>
            </a>
            <a class="tile bg-pink" id="help">
                <div class="tile-content icon">
                    <span class="icon-help"></span>
                </div>
                <div class="brand">
                    <div class="label">帮助</div>
                </div>
            </a>
        </div> <!-- End group -->
		<c:if test="${roleName == '超级管理员'}">
        <div class="tile-group double">
        	<div class="tile-group-title">
            	<span class="icon-clipboard-2"></span>数据管理
            </div>
            <a class="tile bg-cyan" data-click="transform" href="user.jsp">
                <div class="tile-content icon">
                    <span class="icon-user"></span>
                </div>
                <div class="brand">
                    <div class="label">用户管理</div>
                </div>
            </a>

            <a class="tile bg-teal" data-click="transform" href="reports/role.jsp">
                <div class="tile-content icon">
                    <span class="icon-pie"></span>
                </div>
                <div class="brand">
                    <div class="label">角色分析</div>
                </div>
            </a>
            <a class="tile double bg-violet" data-click="transform" href="${pageContext.request.contextPath}/rights.jsp">
                <div class="tile-content icon">
					<span class="icon-cog"></span>
                </div>
                <div class="brand">
                    <div class="label">权限管理</div>
                </div>
            </a>
        </div>
        </c:if>
        </c:if>
</div>
</body>
</html>