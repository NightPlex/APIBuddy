package com.nightplex.apibuddy.createmodule.abc.service;

import com.nightplex.apibuddy.container.ApiBuddyApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by steven.tihomirov on 24.1.2018
 */
@Service
public class CreateAPIService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LogManager.getLogger(ApiBuddyApplication.class);

    public void createSchemaForUser(String userId) {
        logger.debug("Starting to crate new schema for user");
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
    }
}
