package com.doworst.dao.sqlite;

import com.doworst.dao.model.MathTableRowModel;
import com.doworst.dao.MathTableRowDAO;

import javax.sql.RowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class SQLiteMathTableRowDAO implements MathTableRowDAO {

    private final Connection connection;

    public SQLiteMathTableRowDAO() throws SQLException {
        this.connection = SQLiteMyDAOFactory.createConnection();
    }

    @Override
    public void insertTableRow(MathTableRowModel mathTableRowModel) throws SQLException {
        connection.setAutoCommit(false);
        String sql = "INSERT INTO multiplication (NAME, VALUE) " +
                "VALUES(?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, mathTableRowModel.getName());
        preparedStatement.setInt(2, mathTableRowModel.getValue());
        preparedStatement.executeUpdate();

        preparedStatement.close();
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
    public Collection<MathTableRowModel> selectTableRows() {
        Collection<MathTableRowModel> mathTableRows = new ArrayList<MathTableRowModel>();
        String sql = "select * from multiplication";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String  name = rs.getString("name");
                int value  = rs.getInt("value");
                MathTableRowModel m = new MathTableRowModel(name, value);
                mathTableRows.add(m);
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return mathTableRows;
    }
}
