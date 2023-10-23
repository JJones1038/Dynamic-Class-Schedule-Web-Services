package edu.jsu.mcis.cs425.ex2;

import edu.jsu.mcis.cs425.ex2.dao.DAOFactory;
import edu.jsu.mcis.cs425.ex2.dao.PersonnelDAO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.time.LocalTime;


public class Search extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        
        String subjectid = request.getParameter("subjectid");
        int num = Integer.parseInt(request.getParameter("num"));
        String levelid = request.getParameter("levelid");
        String scheduletypeid = request.getParameter("scheduletypeid");
        LocalTime start = LocalTime.parse(request.getParameter("start"));
        LocalTime end = LocalTime.parse(request.getParameter("end"));
        String days = request.getParameter("days");
        
        DAOFactory daoFactory = null;

        ServletContext context = request.getServletContext();

        if (context.getAttribute("daoFactory") == null) {
            System.err.println("*** Creating New DAOFactory Instance ...");
            daoFactory = new DAOFactory();
            context.setAttribute("daoFactory", daoFactory);
        }
        else {
            daoFactory = (DAOFactory) context.getAttribute("daoFactory");
        }

        response.setContentType("text/html;charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            
            PersonnelDAO dao = daoFactory.getPersonnelDAO();

            out.println(dao.find(subjectid, num, levelid, scheduletypeid, start, end, days));

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
