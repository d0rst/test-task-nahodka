package com.doworst.dao;

import com.doworst.dao.oraclexe.OracleXEDAOFactory;
import com.doworst.dao.sqlite.SQLiteMyDAOFactory;

public abstract class MyDAOFactory {

    public abstract MathTableRowDAO getMathTableDAO();

    public static MyDAOFactory getDAOFactory(String whichFactory) {
        if ("SQLITE".equals(whichFactory)) {
            return new SQLiteMyDAOFactory();
        } else if ("ORACLE_XE".equals(whichFactory)) {
            return new OracleXEDAOFactory();
        }
        return null;
    }
}