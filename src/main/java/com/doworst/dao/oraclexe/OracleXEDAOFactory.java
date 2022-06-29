package com.doworst.dao.oraclexe;

import com.doworst.dao.MyDAOFactory;
import com.doworst.dao.MathTableRowDAO;

import java.sql.Connection;

public class OracleXEDAOFactory extends MyDAOFactory {
    public static final String DRIVER=
            "COM.cloudscape.core.RmiJdbcDriver";
    public static final String DBURL=
            "jdbc:cloudscape:rmi://localhost:1099/CoreJ2EEDB";

    // метод для создания соединений к Cloudscape
    public static Connection createConnection() {
        // Использовать DRIVER и DBURL для создания соединения
        // Рекомендовать реализацию/использование пула соединений
        return null;
    }

    public MathTableRowDAO getMathTableDAO() {
        return new OracleXEMathTableRowDAO();
    }
}
