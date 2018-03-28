package com.nightplex.apibuddy.model.databse.create;

/**
 * Created by NightPlex on 3/28/2018
 * Github: https://github.com/NightPlex
 */
public class CreateField {

    private String fieldName;
    private String fieldType;
    private boolean unique;
    private boolean isNull;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        switch (fieldName) {
            case "STRING":
                this.fieldType = "VARCHAR(255)";
            break;
            case "LONG_STRING":
                this.fieldType = "TEXT";
            break;
            case "INTEGER":
                this.fieldType = "INT";
            break;
            case "DOUBLE":
                this.fieldType = "FLOAT";
            break;
        }
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

}
