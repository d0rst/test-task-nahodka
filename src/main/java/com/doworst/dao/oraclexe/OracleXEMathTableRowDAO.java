package com.doworst.dao.oraclexe;

import com.doworst.dao.model.MathTableRowModel;
import com.doworst.dao.MathTableRowDAO;

import javax.sql.RowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class OracleXEMathTableRowDAO implements MathTableRowDAO {

    private final Connection connection;

    public OracleXEMathTableRowDAO() throws SQLException {
        this.connection = OracleXEDAOFactory.createConnection();
    }

    @Override
    public void insertTableRow(MathTableRowModel mathTableRowModel) throws SQLException {
        String sql = "INSERT INTO math (NAME, VALUE) " +
                "VALUES(?, ?)";

        PreparedStatement statement =
                connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, mathTableRowModel.getName());
        statement.setInt(2, mathTableRowModel.getValue());
        statement.executeUpdate();

        statement.close();
        connection.commit();
        connection.close();
    }

    @Override
    public boolean deleteTableRow() {
        return false;
    }

    @Override
    public MathTableRowModel findTableRow() {
        return null;
    }

    @Override
    public boolean updateTableRow() {
        return false;
    }

    @Override
    public RowSet selectTableRowRS() {
        return null;
    }

    @Override
    public Collection<MathTableRowModel> selectTableRows() throws SQLException {
        Collection<MathTableRowModel> mathTableRows = new ArrayList<>();
        String sql = "select * from math";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String  name = rs.getString("name");
            int value  = rs.getInt("value");
            MathTableRowModel m = new MathTableRowModel(name, value);
            mathTableRows.add(m);
        }
        rs.close();
        stmt.close();
        connection.close();
        return mathTableRows;
    }
}
