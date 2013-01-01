<%-- 
    Document   : new
    Created on : 2012-12-30, 15:19:35
    Author     : alan
--%>
<%@ page session="false" %>
<%@ include file="/WEB-INF/commons/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add</title>
        <script src="<c:url value="/resources/javascripts/jquery.js" />"></script>

        <script type="text/javascript">
         
            $.fn.serializeObject = function() {
                var o = {};
                var a = this.serializeArray();
                $.each(a, function() {
                    if (o[this.name]) {
                        if (!o[this.name].push) {
                            o[this.name] = [ o[this.name] ];
                        }
                        o[this.name].push(this.value || '');
                    } else {
                        o[this.name] = this.value || '';
                    }
                });
                return o;
            };

            $(document).ready(
            function() {
                $("#ajaxSubmit").click(function() {
                    
                    var jsonuserinfo = $('#form').serializeObject();
                    $.post("<%=basePath%>account/createByAjax",jsonuserinfo,function(data){
                        alert(data);
                    });

                });
            });
        </script>
    </head>
    <body>
        <div class="container">
            <h1>add user
            </h1>
            <div class="span-12 last">
                <c:url value="/account/create" var="abcURL"/> 
                <form:form modelAttribute="userInfo" id="form" action="${abcURL}" method="post">
                    <fieldset>
                        <legend>Blog Fields</legend>
                        <p>
                            <form:label	for="id" path="id" cssErrorClass="error">id</form:label><br/>
                            <form:input path="id" /> <form:errors path="id" />
                        </p>
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
                            <button id="ajaxSubmit" value="ajaxSubmit" type="button">gggggggggggg</button>
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
