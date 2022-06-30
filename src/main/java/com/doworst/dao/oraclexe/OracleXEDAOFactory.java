package com.doworst.dao.oraclexe;

import com.doworst.App;
import com.doworst.dao.MyDAOFactory;
import com.doworst.dao.MathTableRowDAO;
import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class OracleXEDAOFactory extends MyDAOFactory {

    public static final String DB_URL = App.prop.getProperty("db.url");

    public static Connection createConnection() {
        OracleDataSource ods;
        Connection conn = null;
        try {
            ods = new OracleDataSource();
            ods.setURL(DB_URL);
            ods.setUser(App.prop.getProperty("db.user"));
            ods.setPassword(App.prop.getProperty("db.pass"));
            conn = ods.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public MathTableRowDAO getMathTableDAO() {
        return new OracleXEMathTableRowDAO();
    }
}
