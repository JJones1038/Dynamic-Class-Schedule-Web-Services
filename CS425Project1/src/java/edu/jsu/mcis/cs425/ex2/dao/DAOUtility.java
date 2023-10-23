package edu.jsu.mcis.cs425.ex2.dao;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DAOUtility {

    public static String getResultSetAsJson(ResultSet resultSet) {
        JsonArray jsonArray = new JsonArray();

        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            while (resultSet.next()) {
                JsonObject jsonObject = new JsonObject();

                for (int i = 1; i <= numberOfColumns; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = resultSet.getString(i);
                    jsonObject.put(columnName, columnValue);
                }

                jsonArray.add(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray.toJson();
    }
}
