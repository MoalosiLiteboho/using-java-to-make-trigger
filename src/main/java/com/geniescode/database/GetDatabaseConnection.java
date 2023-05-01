package com.geniescode.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Supplier;

public class GetDatabaseConnection implements Supplier<Connection> {
    public Connection get() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Triggers", "root", "");
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}
