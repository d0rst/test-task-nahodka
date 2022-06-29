package com.doworst.dao.scheme;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "MathTableRow")
public class MathTableRowSchema extends Schema {

    @DatabaseField()
    private String name;

    @DatabaseField()
    private Integer value;

    public MathTableRowSchema(Long id, String name, Integer value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
