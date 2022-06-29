package com.doworst.dao.sqlite;

import com.doworst.dao.model.MathTableRowModel;
import com.doworst.dao.MathTableRowDAO;

import javax.sql.RowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class SQLiteMathTableRowDAO implements MathTableRowDAO {

    private Connection connection;
    private Statement stmt;

    public SQLiteMathTableRowDAO() {
        try {
            this.connection = SQLiteMyDAOFactory.createConnection();
            this.stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertTableRow(MathTableRowModel mathTableRowModel) {

        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO multiplication (NAME, VALUE) " +
                    "VALUES(?, ?)";

            PreparedStatement statement =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, mathTableRowModel.getName());
            statement.setInt(2, mathTableRowModel.getValue());
            statement.executeUpdate();

            statement.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
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
            connection.setAutoCommit(false);
            ResultSet rs = stmt.executeQuery(sql);

            while ( rs.next() ) {
                String  name = rs.getString("name");
                int value  = rs.getInt("value");
                MathTableRowModel m = new MathTableRowModel(name, value);
                mathTableRows.add(m);
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return mathTableRows;
    }
}
