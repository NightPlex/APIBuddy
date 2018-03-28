package com.nightplex.apibuddy.service.database;

import com.nightplex.apibuddy.ApiBuddyApplication;
import com.nightplex.apibuddy.model.databse.create.CreateField;
import com.nightplex.apibuddy.model.databse.create.CreateTable;
import com.nightplex.apibuddy.model.databse.insert.InsertField;
import com.nightplex.apibuddy.model.databse.insert.InsertTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by NightPlex on 3/28/2018
 * Github: https://github.com/NightPlex
 *
 * Responsible for handling single user transactions to database
 */
@Service
public class UserPersistenceService {

    private JdbcTemplate jdbcTemplate;
    private DataSourceService dataSourceService;

    @Autowired
    public UserPersistenceService(JdbcTemplate jdbcTemplate, DataSourceService dataSourceService) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSourceService = dataSourceService;
    }

    private static final Logger logger = LogManager.getLogger(ApiBuddyApplication.class);

    public void createDatabase (String databaseId) {
        jdbcTemplate.execute("CREATE DATABASE" + " IF NOT EXISTS " + databaseId);
        logger.info("Created database "+ databaseId);
    }

    public void createTable(String databaseId, CreateTable createTable) {
        Map<String, Object> params = createTable.getFields().stream().collect(Collectors.toMap(CreateField::getFieldName, CreateField::getFieldType));
    }

    public void insertToTable(String databaseId, InsertTable insertTable) {
        Map<String, Object> params = insertTable.getFields().stream()
                .collect(Collectors.toMap(InsertField::getFieldName, InsertField::getFieldValue));

        dataSourceService.getInsertTemplateForUser(databaseId, insertTable.getTableName())
                .execute(params);
    }
}
