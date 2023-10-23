package edu.jsu.mcis.cs425.ex2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

public class PersonnelDAO {
    
    private static final String QUERY_FIND = "SELECT course.*, section.*, "
        + "term.name AS termname, term.`start` AS termstart, term.`end` AS termend, "
        + "scheduletype.description as scheduletype, `level`.description as `level` "
        + "FROM ((((section JOIN scheduletype ON section.scheduletypeid = scheduletype.id) "
        + "JOIN course ON section.subjectid = course.subjectid AND section.num = course.num) "
        + "JOIN `level` ON course.levelid = `level`.id) "
        + "JOIN term ON section.termid = term.id) "
        + "WHERE ((? IS NULL OR course.subjectid = ?) "    
        + "AND (? IS NULL OR course.num = ?) "             
        + "AND (? IS NULL OR `level`.id = ?) "             
        + "AND (? IS NULL OR section.scheduletypeid = ?) " 
        + "AND (? IS NULL OR section.`start` >= ?) "       
        + "AND (? IS NULL OR section.`end` <= ?) "         
        + "AND (? IS NULL OR section.days REGEXP ?) "      
        + "AND (section.termid = ?)) "                     
        + "ORDER BY course.num, section";
    
    private final DAOFactory daoFactory;
    
    public PersonnelDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    public JsonArray find(String subjectid, int num, String levelid, String scheduletypeid, 
        LocalTime start, LocalTime end, String days) {

        JsonArray results = new JsonArray();

        try (Connection conn = daoFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(QUERY_FIND)) {

            // Set the parameters
            ps.setString(1, null);
            ps.setString(2, subjectid);
            ps.setInt(3, 0);
            ps.setInt(4, num);
            ps.setString(5, null);
            ps.setString(6, levelid);
            ps.setString(7, null);
            ps.setString(8, scheduletypeid);
            ps.setTime(9, Time.valueOf(start));
            ps.setTime(10, Time.valueOf(start));
            ps.setTime(11, Time.valueOf(end));
            ps.setTime(12, Time.valueOf(end));
            ps.setString(13, null);
            ps.setString(14, days);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    JsonObject result = new JsonObject();
                    ResultSetMetaData metaData = rs.getMetaData();
                    int numberOfColumns = metaData.getColumnCount();

                    for (int i = 1; i <= numberOfColumns; i++) {
                        String key = metaData.getColumnLabel(i);
                        String value = rs.getString(i);
                        result.put(key, value);
                    }

                    results.add(result);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}
