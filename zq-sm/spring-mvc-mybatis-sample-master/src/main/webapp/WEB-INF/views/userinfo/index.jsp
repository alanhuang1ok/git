<%-- 
    Document   : show
    Created on : 2012-12-30, 14:48:57
    Author     : alan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>userinfo</title>
        <!--[if lt IE 8]>
              <link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection">
      <![endif]-->
    </head>
    <body>
        <div class="container">
            <h1>
                UserInfo 
            </h1>
            <table>
                <tr><td>id</td><td>name</td><td>age</td></tr>
                <c:forEach var="userInfo" items="${userInfos}">
                    <tr>
                        <c:url var="editUrl" value="${userInfo.id}/edit">
                        </c:url>
                        <c:url var="deleteUrl" value="${userInfo.id}/delete">
                        </c:url>
                        <td>${userInfo.id}</td>
                        <td>${userInfo.name}</td>
                        <td>${userInfo.age}</td>
                        <td>
                            <a href='<c:out value="${editUrl}"/>'><fmt:message key="button.edit"/></a>
                    <sec:authorize ifAllGranted="ROLE_ADMIN">
                        <a href='<c:out value="${deleteUrl}" />'><fmt:message key="button.delete"/></a>
                    </sec:authorize>
                    </td>
                    </tr>
                </c:forEach>
            </table>
            <ul>
                <li> <a  href='<%=path%>/account/new'>添加</a> </li>
            </ul>
        </div>
    </body>
</html>
