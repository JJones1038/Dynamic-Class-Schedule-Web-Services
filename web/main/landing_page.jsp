<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edu.jsu.mcis.cs425.ex2.dao.*" %>
<jsp:useBean id="params" class="edu.jsu.mcis.cs425.ex2.ParameterBean" scope="session"/>

<%
    
    DAOFactory daoFactory = null;

    ServletContext context = request.getServletContext();

    if (context.getAttribute("daoFactory") == null) {
        System.err.println("*** Creating new DAOFactory ...");
        daoFactory = new DAOFactory();
        context.setAttribute("daoFactory", daoFactory);
    }
    else {
        daoFactory = (DAOFactory) context.getAttribute("daoFactory");
    }
    
    FormDAO dao = daoFactory.getFormDAO();

%>

<!DOCTYPE html>
<html>
    
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dynamic Schedule</title>
        
    </head>
    
    <body>
        
        <h3>Dynamic Schedule</h3>
        
        <form action="<%= request.getContextPath() %>/main/search_page.jsp" method="POST">
            
            <fieldset>
                
                <legend>Select a Term</legend>
                
                <%= dao.getTermListAsHTML() %>
                
                <p>
                    <input type="submit" value="Submit">
                </p>
                
            </fieldset>
        </form>
    </body>
</html>
