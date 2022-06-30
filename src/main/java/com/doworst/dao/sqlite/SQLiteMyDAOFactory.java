package com.doworst.dao.sqlite;

import com.doworst.App;
import com.doworst.dao.MyDAOFactory;
import com.doworst.dao.MathTableRowDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteMyDAOFactory extends MyDAOFactory {

    private static final String DB_URL = App.prop.getProperty("db.url");

    private static Connection connection;

    public static Connection createConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(DB_URL);
        return connection;
    }

    public Connection getConnectionSource() {
        return connection;
    }

    public MathTableRowDAO getMathTableDAO() {
        return new SQLiteMathTableRowDAO();
    }
}
