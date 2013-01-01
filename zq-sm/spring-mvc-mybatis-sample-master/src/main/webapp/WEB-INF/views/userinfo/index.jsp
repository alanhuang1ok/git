<%@ page session="false" %>
<%@ include file="/WEB-INF/commons/taglibs.jsp" %>
<%-- 
    Document   : show
    Created on : 2012-12-30, 14:48:57
    Author     : alan
--%>
<!DOCTYPE html>

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
                  <li> <a  href='<%=path%>/account/new'>add</a> </li>
                 </ul>
        </div>
    </body>
</html>
