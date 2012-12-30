<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title><fmt:message key="welcome.title"/></title>
		<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection">
		<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print">
		<!--[if lt IE 8]>
		<link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection">
		<![endif]-->
	</head>
	<body>
		<div class="container">
			<h1>
				<fmt:message key="welcome.title"/>
			</h1>
			<p>
			Locale = ${pageContext.response.locale}
			</p>
			<hr>
			<ul>
				<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
			</ul>
			<ul>
				<li><a href="blogs">Blogs</a></li>
                                <li><a href="<%=basePath%>/account/getAllList">用户表操作  UserInfo</a></li>
			</ul>
		</div>
	</body>
</html>
