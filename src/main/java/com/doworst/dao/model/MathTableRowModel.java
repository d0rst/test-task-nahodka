package com.doworst.dao.model;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * Class model of a row in a multiplication table.
 *
 */
public class MathTableRowModel {
    /** column name in the table e.g. a1, a2 .. b1, b2 */
    private String name;

    /** value in the table */
    private Integer value;

    /** map contains the value of the multiplication table */
    private Map<String, Integer> mulMap;

    /** default constructor */
    public MathTableRowModel() {}
    /**
     * Constructor - create and fill in the multiplication table
     * @param name - column name e.g. a1, a2
     * @param value - value in the table a1 = 4, a2 = 8
     */

    public MathTableRowModel(String name, Integer value) {
        this.name = name;
        this.value = value;
        this.mulMap = new HashMap<String, Integer>();
        for (int i = 1; i < 10; i++) {
            mulMap.put(name + i, value * i);
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

    public Map<String, Integer> getMulMap() {
        return mulMap;
    }

    public void setMulMap(Map<String, Integer> mulMap) {
        this.mulMap = mulMap;
    }

    @Override
    public String toString() {
        return "MathTableRowModel{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", mulMap=" + mulMap +
                '}';
    }
}