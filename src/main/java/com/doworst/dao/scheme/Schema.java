package com.doworst.dao.scheme;

import com.j256.ormlite.field.DatabaseField;

public class Schema {
    @DatabaseField(generatedId = true)
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
