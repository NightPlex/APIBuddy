package com.nightplex.apibuddy.model;

import org.springframework.jdbc.datasource.DelegatingDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by NightPlex on 3/28/2018
 * Github: https://github.com/NightPlex
 */
public class UserDelegatingDataSource extends DelegatingDataSource{
    private final String catalogName;

    public UserDelegatingDataSource(final String catalogName, final DataSource dataSource) {
        super(dataSource);
        this.catalogName = catalogName;
    }

    @Override
    public Connection getConnection() throws SQLException {
        final Connection cnx = super.getConnection();
        cnx.setCatalog(this.catalogName);
        return cnx;
    }
}
