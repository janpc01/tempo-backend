package com.backend.tempo.config;

import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        // Fetch secret containing all DB credentials (Modify "POSTGRESQL_SECRET" to your actual secret name)
        String postgresSecret = System.getenv("POSTGRESQL_SECRET");

        // Parse JSON secret
        JSONObject secret = new JSONObject(postgresSecret);
        String host = secret.getString("POSTGRESQL_HOST");
        String dbName = secret.getString("POSTGRESQL_DB");
        String username = secret.getString("POSTGRESQL_USERNAME");
        String password = secret.getString("POSTGRESQL_PASSWORD");

        // Construct JDBC URL
        String jdbcUrl = String.format("jdbc:postgresql://%s:%s@%s/%s?sslmode=require", username, password, host, dbName);

        // Configure DataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}
