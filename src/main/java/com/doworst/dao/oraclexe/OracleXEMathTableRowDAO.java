package com.doworst.dao.oraclexe;

import com.doworst.dao.model.MathTableRowModel;
import com.doworst.dao.MathTableRowDAO;

import javax.sql.RowSet;
import java.util.Collection;

public class OracleXEMathTableRowDAO implements MathTableRowDAO {
    @Override
    public void insertTableRow(MathTableRowModel tableRowModel) {}

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
        return null;
    }
}
