package com.doworst.dao;

import com.doworst.dao.model.MathTableRowModel;

import javax.sql.RowSet;
import java.util.Collection;

public interface MathTableRowDAO {

    void insertTableRow(MathTableRowModel tableRowModel);

    boolean deleteTableRow();

    MathTableRowModel findTableRow();

    boolean updateTableRow();

    RowSet selectTableRowRS();

    Collection selectTableRows();
}
