package com.nightplex.apibuddy.controller;

import com.nightplex.apibuddy.service.CreateAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;

@RestController
public class TestController {

    @Autowired
    private CreateAPIService createAPIService;

    @GetMapping("/test")
    public String test() throws SQLException {
        createAPIService.createDatabaseForUser("new");
        createAPIService.createTableForUser("new", "test", new HashMap<>());
        return "test";
    }
}
