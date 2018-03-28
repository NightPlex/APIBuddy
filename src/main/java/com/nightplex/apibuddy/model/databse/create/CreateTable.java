package com.nightplex.apibuddy.model.databse.create;

import java.util.List;

/**
 * Created by NightPlex on 3/28/2018
 * Github: https://github.com/NightPlex
 */
public class CreateTable {

    private String tableName;
    private List<CreateField> fields;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<CreateField> getFields() {
        return fields;
    }

    public void setFields(List<CreateField> fields) {
        this.fields = fields;
    }
}
