package com.doworst.dao;

import com.doworst.dao.model.MathTableRowModel;

import javax.sql.RowSet;
import java.sql.SQLException;
import java.util.Collection;

public interface MathTableRowDAO {
    /** adding a row to a table */
    void insertTableRow(MathTableRowModel tableRowModel) throws SQLException;

    /** deleting a row in a table */
    boolean deleteTableRow();

    /** search for a row in a table */
    MathTableRowModel findTableRow();

    /** updating a row in a table */
    boolean updateTableRow();

    /** select rows as RowSet */
    RowSet selectTableRowRS();

    /** select all rows as a Сollection */
    Collection selectTableRows() throws SQLException;
}
