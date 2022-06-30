package com.doworst.dao;

import com.doworst.dao.oraclexe.OracleXEDAOFactory;
import com.doworst.dao.sqlite.SQLiteMyDAOFactory;
/**
 * Factory class for setting up a data connection
 */
public abstract class MyDAOFactory {
    /** method for handling crud requests */
    public abstract MathTableRowDAO getMathTableDAO();

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