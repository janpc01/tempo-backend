package com.backend.tempo.config;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean
    public DataSource dataSource() {
        logger.info("Configuring the DataSource bean");

        try {
            // Fetch secret containing all DB credentials (Modify "POSTGRESQL_SECRET" to your actual secret name)
            // String postgresSecret = System.getenv("POSTGRESQL_SECRET");

            // Parse JSON secret
            // JSONObject secret = new JSONObject(postgresSecret);
            // String host = secret.getString("POSTGRESQL_HOST");
            // String dbName = secret.getString("POSTGRESQL_DB");
            // String username = secret.getString("POSTGRESQL_USER");
            // String password = secret.getString("POSTGRESQL_PASSWORD");

            // Construct JDBC URL
            // String jdbcUrl = String.format("jdbc:postgresql://%s:5432/%s", host, dbName);
            // jdbc:postgresql://<host>:<port>/<dbname>?sslmode=require


            // Configure DataSource
            // DriverManagerDataSource dataSource = new DriverManagerDataSource();
            // dataSource.setDriverClassName("org.postgresql.Driver");
            // dataSource.setUrl(jdbcUrl);
            // dataSource.setUsername(username);
            // dataSource.setPassword(password);
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl("jdbc:postgresql://ep-noisy-waterfall-a4o5vgrn-pooler.us-east-1.aws.neon.tech:5432/neondb");
            dataSource.setUsername("neondb_owner");
            dataSource.setPassword("npg_9Fd5sYxlmzWk");

            logger.info("DataSource configured successfully with URL: {}", dataSource.getUrl());
            return dataSource;
        } catch (Exception e) {
            logger.error("Error configuring DataSource", e);
            throw e;
        }
    }
}
