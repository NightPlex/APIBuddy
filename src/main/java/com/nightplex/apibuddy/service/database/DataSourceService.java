package com.nightplex.apibuddy.service.database;

import com.nightplex.apibuddy.model.UserDelegatingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

/**
 * Created by NightPlex on 3/28/2018
 * Github: https://github.com/NightPlex
 */

@Service
public class DataSourceService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DataSourceService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getTemplateForUser(String databaseId) {
        return new JdbcTemplate(new UserDelegatingDataSource(databaseId, jdbcTemplate.getDataSource()));
    }

    public SimpleJdbcInsert getInsertTemplateForUser(String databaseId) {
        return new SimpleJdbcInsert(new UserDelegatingDataSource(databaseId, jdbcTemplate.getDataSource()));
    }

    public SimpleJdbcInsert getInsertTemplateForUser(String databaseId, String tableName) {
        return new SimpleJdbcInsert(new UserDelegatingDataSource(databaseId, jdbcTemplate.getDataSource())).withTableName(tableName);
    }
}
