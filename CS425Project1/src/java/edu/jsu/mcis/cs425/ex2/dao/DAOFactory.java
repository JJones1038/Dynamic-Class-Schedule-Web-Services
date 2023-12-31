package edu.jsu.mcis.cs425.ex2.dao;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public final class DAOFactory {
    
    private static final String PREFIX = "ex2";
    private static final String PROPERTY_ENVCONTEXT = "envcontext";
    private static final String PROPERTY_INITCONTEXT = "initcontext";
    
    private Connection conn;
    
    public DAOFactory() {

        DAOProperties properties = new DAOProperties(PREFIX);

        String envcontext = properties.getProperty(PROPERTY_ENVCONTEXT);
        String initcontext = properties.getProperty(PROPERTY_INITCONTEXT);
        
        try {
            Context envContext = new InitialContext();
            Context initContext = (Context) envContext.lookup(envcontext);
            DataSource ds = (DataSource) initContext.lookup(initcontext);
            if (ds != null) {
                this.conn = ds.getConnection();
            }
        }
        catch (Exception e) {
            conn = null;
            e.printStackTrace();
        }
        
    }
    
    Connection getConnection() {
        return conn;
    }
    
    public boolean isClosed() {
        
        boolean isClosed = true;
        
        try {
            isClosed = conn.isClosed();
        }
        catch (Exception e) { e.printStackTrace(); }
        
        return isClosed;
        
    }
    
    public PersonnelDAO getPersonnelDAO() {
        return new PersonnelDAO(this);
    }
    
}