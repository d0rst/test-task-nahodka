package com.doworst.dao.oraclexe;

import com.doworst.App;
import com.doworst.dao.MyDAOFactory;
import com.doworst.dao.MathTableRowDAO;
import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * Factory class for working with Oracle XE connection
 */
public class OracleXEDAOFactory extends MyDAOFactory {
    /** link to the path to the database from the config */
    public static final String DB_URL = App.prop.getProperty("db.url");

    private static Connection connection;

    /** Method for creating a database connection */
    public static Connection createConnection() {
        OracleDataSource ods;
        try {
            ods = new OracleDataSource();
            ods.setURL(DB_URL);
            ods.setUser(App.prop.getProperty("db.user"));
            ods.setPassword(App.prop.getProperty("db.pass"));
            connection = ods.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public Connection getConnectionSource() {
        return connection;
    }

    public MathTableRowDAO getMathTableDAO() {
        return new OracleXEMathTableRowDAO();
    }
}
