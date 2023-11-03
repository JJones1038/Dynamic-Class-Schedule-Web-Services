<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edu.jsu.mcis.cs425.ex2.dao.*" %>
<jsp:useBean id="params" class="edu.jsu.mcis.cs425.ex2.ParameterBean" scope="session"/>

<jsp:setProperty name="params" property="*" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%= params.getParametersAsHTML() %>
        <h1>Hello World!</h1>
    </body>
</html>
