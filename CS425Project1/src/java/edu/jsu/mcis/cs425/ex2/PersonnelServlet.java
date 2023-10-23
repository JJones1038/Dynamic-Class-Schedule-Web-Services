//package edu.jsu.mcis.cs425.ex2;
//
//import java.io.PrintWriter;
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import edu.jsu.mcis.cs425.ex2.dao.*;
//
//public class PersonnelServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//
//        DAOFactory daoFactory = null;
//
//        ServletContext context = request.getServletContext();
//
//        if (context.getAttribute("daoFactory") == null) {
//            System.err.println("*** Creating New DAOFactory Instance ...");
//            daoFactory = new DAOFactory();
//            context.setAttribute("daoFactory", daoFactory);
//        }
//        else {
//            daoFactory = (DAOFactory) context.getAttribute("daoFactory");
//        }
//
//        response.setContentType("text/html;charset=UTF-8");
//
//        try ( PrintWriter out = response.getWriter()) {
//
//            String lastname = request.getParameter("search");
//            out.println("<p>Search Parameter: " + lastname + "</p>");
//            
//            PersonnelDAO dao = daoFactory.getPersonnelDAO();
//
//            out.println(dao.find(lastname));
//
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//        doGet(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Personnel Servlet";
//    }
//
//}