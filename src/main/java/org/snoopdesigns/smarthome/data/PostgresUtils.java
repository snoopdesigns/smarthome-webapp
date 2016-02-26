package org.snoopdesigns.smarthome.data;

import com.heroku.sdk.jdbc.DatabaseUrl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostgresUtils {

    public void initTables() {
        Connection connection = null;
        try {
            connection = DatabaseUrl.extract().getConnection();

            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS data (time timestamp, v1 varchar, v2 " +
                    "varchar, temp varchar, hum varchar)");
            stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
            ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

            ArrayList<String> output = new ArrayList<String>();
            while (rs.next()) {
                output.add( "Read from DB: " + rs.getTimestamp("tick"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) try{connection.close();} catch(SQLException e){}
        }
    }

    public void insertNewData(Data data) {
        Connection connection = null;
        try {
            connection = DatabaseUrl.extract().getConnection();

            Statement stmt = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO data VALUES (now(),");
            sb.append("\"");
            sb.append(data.getVoltage1());
            sb.append("\",");
            sb.append("\"");
            sb.append(data.getVoltage2());
            sb.append("\",");
            sb.append("\"");
            sb.append(data.getTemperature());
            sb.append("\",");
            sb.append("\"");
            sb.append(data.getHumidity());
            sb.append("\")");
            stmt.executeUpdate(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) try{connection.close();} catch(SQLException e){}
        }
    }

    public List<Data> getAllData() {
        List<Data> result = new ArrayList<Data>();
        Connection connection = null;
        try {
            connection = DatabaseUrl.extract().getConnection();

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM data");

            while (rs.next()) {
                Data d = new Data(
                        rs.getTimestamp("time").toString(),
                        rs.getString("v1"),
                        rs.getString("v2"),
                        rs.getString("temp"),
                        rs.getString("hum")
                );
                result.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) try{connection.close();} catch(SQLException e){}
        }
        return result;
    }
}
