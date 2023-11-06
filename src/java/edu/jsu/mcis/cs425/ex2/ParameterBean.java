package edu.jsu.mcis.cs425.ex2;

import java.util.HashMap;

public class ParameterBean {

    private HashMap<String, String> parameters = null;
    
    private String days;

    public ParameterBean() {
        parameters = new HashMap<>();
    }

    public String getParametersAsHTML() {

        StringBuilder s = new StringBuilder();

        for (HashMap.Entry<String, String> e : parameters.entrySet()) {

            s.append("<p>");
            s.append("Key: ").append(e.getKey()).append(", ");
            s.append("Value: ").append(e.getValue());
            s.append("</p>");

        }

        return s.toString();

    }
    
    public void setTermid(String termid) {
        parameters.put("termid", termid);
    }
    
    public void setSubjectid(String termid) {
        parameters.put("subjectid", termid);
    }
    
    public void setScheduletypeid(String termid) {
        parameters.put("scheduletypeid", termid);
    }
    
    public void setLevelid(String termid) {
        parameters.put("levelid", termid);
    }
    
    public void setBoxmon(String termid) {
        parameters.put("boxmon", termid);
        setDays();
    }
    
    public void setBoxtue(String termid) {
        parameters.put("boxtue", termid);
        setDays();
    }
    
    public void setBoxwed(String termid) {
        parameters.put("boxwed", termid);
        setDays();
    }
    
    public void setBoxthu(String termid) {
        parameters.put("boxthu", termid);
        setDays();
    }
    
    public void setBoxfri(String termid) {
        parameters.put("boxfri", termid);
        setDays();
    }
    
    private void setDays() {
        
        StringBuilder s = new StringBuilder();
        
        if (parameters.get("boxmon") != null) {
            s.append("M");
        }
        if (parameters.get("boxtue") != null) {
            s.append("T");
        }
        if (parameters.get("boxwed") != null) {
            s.append("W");
        }
        if (parameters.get("boxthu") != null) {
            s.append("R");
        }
        if (parameters.get("boxfri") != null) {
            s.append("F");
        }
        
        this.days = s.toString();
        
        parameters.put("days", days);
        
    }

}