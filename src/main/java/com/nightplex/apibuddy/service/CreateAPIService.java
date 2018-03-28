package com.nightplex.apibuddy.service;

import com.nightplex.apibuddy.ApiBuddyApplication;
import com.nightplex.apibuddy.model.UserDelegatingDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by NightPlex on 3/28/2018
 * Github: https://github.com/NightPlex
 */
@Service
public class CreateAPIService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LogManager.getLogger(ApiBuddyApplication.class);

    public void createSchemaForUser(String userId) {
        logger.debug("Starting to crate new schema for user");
    }

    public void createDatabaseForUser(String userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE DATABASE").append(" IF NOT EXISTS ").append(userId);
        jdbcTemplate.execute(sql.toString());
        logger.info("Created database "+ userId);
    }

    public void createTableForUser(String userId, String tableName, Map<String, String> fields) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE Persons (\n" +
                "    PersonID int,\n" +
                "    LastName varchar(255),\n" +
                "    FirstName varchar(255),\n" +
                "    Address varchar(255),\n" +
                "    City varchar(255) \n" +
                ")");
        getTemplateForUser(userId).execute(sql.toString());
    }

    public JdbcTemplate getTemplateForUser(String userId) {
        return new JdbcTemplate(new UserDelegatingDataSource(userId, jdbcTemplate.getDataSource()));
    }
}
