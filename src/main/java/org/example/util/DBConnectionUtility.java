package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtility {
    public static Connection getDBConnection() {

        String DATASOURCE_CONTEXT = "jdbc:sqlite:G:/TestWEBApp/sqlite/contacts.db";
        Connection result = null;

        try {
            Class.forName("org.sqlite.JDBC");
            result = DriverManager.getConnection(DATASOURCE_CONTEXT);

            if (result != null) {
            } else {
                log("Failed to lookup datasource.");
            }
        } catch (SQLException ex) {
            log("Cannot get connection: " + ex);
        } catch (Throwable te) {
            te.printStackTrace();
        }
        return result;
    }

    private static void log(Object aObject) {
        System.out.println(aObject);
    }
}



