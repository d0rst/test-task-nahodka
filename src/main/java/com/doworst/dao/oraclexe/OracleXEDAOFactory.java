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
    private static Connection connection;

    /** Method for creating a database connection */
    public static Connection createConnection() throws SQLException {
        OracleDataSource ods;
        ods = new OracleDataSource();
        ods.setURL(App.prop.getProperty("db.url"));
        ods.setUser(App.prop.getProperty("db.user"));
        ods.setPassword(App.prop.getProperty("db.pass"));
        connection = ods.getConnection();
        return connection;
    }

    public Connection getConnectionSource() {
        return connection;
    }

    public MathTableRowDAO getMathTableDAO() throws SQLException {
        return new OracleXEMathTableRowDAO();
    }
}
