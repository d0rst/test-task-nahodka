package com.doworst.dao;

import com.doworst.dao.oraclexe.OracleXEDAOFactory;
import com.doworst.dao.sqlite.SQLiteMyDAOFactory;

import java.sql.SQLException;

/**
 * Factory class for setting up a data connection
 */
public abstract class MyDAOFactory {
    /** method for handling crud requests */
    public abstract MathTableRowDAO getMathTableDAO() throws SQLException;

    /** config connection setup method */
    public static MyDAOFactory getDAOFactory(String whichFactory) {
        if ("SQLITE".equals(whichFactory)) {
            return new SQLiteMyDAOFactory();
        }
        if ("ORACLE_XE".equals(whichFactory)) {
            return new OracleXEDAOFactory();
        }
        return null;
    }
}