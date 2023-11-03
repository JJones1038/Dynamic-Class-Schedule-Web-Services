<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edu.jsu.mcis.cs425.ex2.dao.*" %>
<jsp:useBean id="params" class="edu.jsu.mcis.cs425.ex2.ParameterBean" scope="session"/>

<jsp:setProperty name="params" property="*" />

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
        <title>Class Schedule Search</title>
    </head>
    <body>
        <h3>Class Schedule Search</h3>
        
        <%= params.getParametersAsHTML() %>
        
        <form action="<%= request.getContextPath() %>/main/search_results_page.jsp" method="POST">
            
            <fieldset>
                
                <legend>Search Course Catalog</legend>
                
                <label for="subjectid"><strong>Subject:</strong>&nbsp;</label>
                
                <%= dao.getSubjectListAsHTML() %>
                
                <p>
                    <label>Course Number: </label> &emsp;
                    <input type="text">
                </p>
                

                <label for="scheduletypeid"><strong>Schedule Type:</strong>&nbsp;</label>
                
                <%= dao.getScheduleTypeListAsHTML() %>
   
                
                <p>
                    <label>Course Level: </label> &emsp;
                    <select>
                        <option></option>
                    </select>
                </p>
                
                <p>
                    <label>Start Time: Hour </label>
                    <select>
                        <option></option>
                    </select>
                    
                    <label>Minute: </label>
                    <select>
                        <option></option>
                    </select>
                    
                    <label>AM/PM: </label>
                    <select>
                        <option></option>
                    </select>   
                </p>
                
                <p>
                    <label>End Time: Hour </label>
                    <select>
                        <option></option>
                    </select>
                    
                    <label>Minute: </label>
                    <select>
                        <option></option>
                    </select>
                    
                    <label>AM/PM: </label>
                    <select>
                        <option></option>
                    </select>   
                </p>
                
                <p>
                    <input name="boxmon" type="checkbox">
                    <label>Mon</label>
                    
                    <input name="boxtue" type="checkbox">
                    <label>Tue</label>
                    
                    <input name="boxwed" type="checkbox">
                    <label>Wed</label>
                    
                    <input name="boxthu" type="checkbox">
                    <label>Thur</label>
                    
                    <input name="boxfri" type="checkbox">
                    <label>Fri</label>
                </p>
                
                <p>
                    <input type="submit" value="Submit">
                    <input type="submit" value="Reset">
                </p>
                
            </fieldset>
        </form>
    </body>
</html>
