package com.doworst.dao.model;

import java.util.HashMap;
import java.util.Map;


public class MathTableRowModel {
    private String name;
    private Integer value;
    private Map<String, Integer> mulList;

    public MathTableRowModel() {}

    public MathTableRowModel(String name, Integer value) {
        this.name = name;
        this.value = value;
        this.mulList = new HashMap<String, Integer>();
        for (int i = 1; i < 10; i++) {
            mulList.put(name + i, value * i);
        }
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

    public Map<String, Integer> getMulList() {
        return mulList;
    }

    public void setMulList(Map<String, Integer> mulList) {
        this.mulList = mulList;
    }

    @Override
    public String toString() {
        return "MathTableRowModel{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", mulList=" + mulList +
                '}';
    }
}