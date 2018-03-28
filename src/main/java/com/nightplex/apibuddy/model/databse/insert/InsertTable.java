package com.nightplex.apibuddy.model.databse.insert;

import java.util.List;

/**
 * Created by NightPlex on 3/28/2018
 * Github: https://github.com/NightPlex
 */
public class InsertTable {

    private String tableName;
    private List<InsertField> fields;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<InsertField> getFields() {
        return fields;
    }

    public void setFields(List<InsertField> fields) {
        this.fields = fields;
    }
}
