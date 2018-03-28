package com.nightplex.apibuddy.controller;

import com.nightplex.apibuddy.model.databse.create.CreateTable;
import com.nightplex.apibuddy.service.database.UserPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NightPlex on 3/28/2018
 * Github: https://github.com/NightPlex
 */
@RestController
@RequestMapping("/api/v2/user")
public class UserPersistenceController {

    @Autowired
    private UserPersistenceService userPersistenceService;

    @PostMapping
    public HttpEntity<String> createNewTable(@RequestParam String databaseId) {
        userPersistenceService.createDatabase(databaseId);
        return new HttpEntity<>("OK");
    }

    @PostMapping("/table")
    public HttpEntity<String> createNewTable(@RequestParam String databaseId, @RequestBody CreateTable createTable) {
        userPersistenceService.createTable(databaseId, createTable);
        return new HttpEntity<>("OK");
    }
}
