package edu.jsu.mcis.cs425.ex2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FormDAO {
    
    private final DAOFactory daoFactory;
    
    private final String QUERY_TERM_LIST = "SELECT * FROM term";
    private final String QUERY_SUBJECT_LIST = "SELECT * FROM subject ORDER BY name";
    private final String QUERY_SCHEDULETYPE_LIST = "SELECT * FROM scheduletype";
    
    FormDAO(DAOFactory dao) {
        this.daoFactory = dao;
    }
    
    public String getTermListAsHTML() {

        StringBuilder s = new StringBuilder();

        Connection conn = daoFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(QUERY_TERM_LIST);
            
            boolean hasresults = ps.execute();

            if (hasresults) {
                
                s.append("<select id=\"termid\" name=\"termid\">");

                rs = ps.getResultSet();
                
                while (rs.next()) {
                    
                    s.append("<option value=\"").append(rs.getInt("id")).append("\">");
                    s.append(rs.getString("name"));
                    s.append("</option>");
                                                           
                }
                
                s.append("</select>");
                        
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                }
                catch (Exception e) {
                    e.printStackTrace(); 
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                    ps = null;
                }
                catch (Exception e) {
                    e.printStackTrace(); 
                }
            } 
        }
        return (s.toString());
    }
    
    public String getSubjectListAsHTML() {

        StringBuilder s = new StringBuilder();

        Connection conn = daoFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(QUERY_SUBJECT_LIST);
            
            boolean hasresults = ps.execute();

            if (hasresults) {
                
                s.append("<select id=\"subjectid\" name=\"subjectid\">");

                rs = ps.getResultSet();
                
                while (rs.next()) {
                    
                    s.append("<option value=\"").append(rs.getString("id")).append("\">");
                    s.append(rs.getString("name"));
                    s.append("</option>");
                                                           
                }
                
                s.append("</select>");
                        
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                }
                catch (Exception e) {
                    e.printStackTrace(); 
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                    ps = null;
                }
                catch (Exception e) {
                    e.printStackTrace(); 
                }
            } 
        }
        return (s.toString());
    }
    
    public String getScheduleTypeListAsHTML() {

        StringBuilder s = new StringBuilder();

        Connection conn = daoFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(QUERY_SCHEDULETYPE_LIST);
            
            boolean hasresults = ps.execute();

            if (hasresults) {
                
                s.append("<select id=\"scheduletypeid\" name=\"scheduletypeid\">");

                rs = ps.getResultSet();
                
                while (rs.next()) {
                    
                    s.append("<option value=\"").append(rs.getString("id")).append("\">");
                    s.append(rs.getString("description"));
                    s.append("</option>");
                                                           
                }
                
                s.append("</select>");
                        
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                }
                catch (Exception e) {
                    e.printStackTrace(); 
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                    ps = null;
                }
                catch (Exception e) {
                    e.printStackTrace(); 
                }
            } 
        }
        return (s.toString());
    }
   
}