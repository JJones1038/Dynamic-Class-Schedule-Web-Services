package edu.jsu.mcis.cs425.ex2;

import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.github.cliftonlabs.json_simple.*;

public class Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        
        response.setContentType("application/json;charset=UTF-8");
        
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response){
        
        
    }

    @Override
    public String getServletInfo() {
        return "Public Servlet";
    }

}