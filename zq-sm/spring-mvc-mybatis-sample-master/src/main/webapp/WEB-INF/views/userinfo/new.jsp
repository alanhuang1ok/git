<%-- 
    Document   : new
    Created on : 2012-12-30, 15:19:35
    Author     : alan
--%>

<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>添加</title>
    </head>
    <body>
        <div class="container">
            <h1>
                添加用户
            </h1>
            <div class="span-12 last">
                <c:url value="/account/create" var="abcURL"/> 
                <form:form modelAttribute="userInfo" action="${abcURL}" method="post">
                    <fieldset>
                        <legend>Blog Fields</legend>
                        <p>
                            <form:label	for="name" path="name" cssErrorClass="error">name</form:label><br/>
                            <form:input path="name" /> <form:errors path="name" />
                        </p>
                        <p>
                            <form:label for="age" path="age" cssErrorClass="error">age</form:label><br/>
                            <form:input path="age"  /> <form:errors path="age" />
                        </p>
                        
                        <p>
                            <input type="submit" />
                        </p>
                    </fieldset>
                </form:form>
            </div>
            <hr>
            <ul>
                <li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
            </ul>
        </div>
    </body>
</html>
