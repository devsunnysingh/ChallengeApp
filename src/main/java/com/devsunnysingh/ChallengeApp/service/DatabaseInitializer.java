package com.devsunnysingh.ChallengeApp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseInitializer implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Check if the table exists
        String sql = "SHOW TABLES LIKE 'challenge'";
        String result = jdbcTemplate.queryForObject(sql, String.class);

        if (result == null) {
            // Table does not exist, create it
            String createTableSql = "CREATE TABLE challenge (" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "month VARCHAR(255), " +
                    "description VARCHAR(255)" +
                    ")";
            jdbcTemplate.execute(createTableSql);
            logger.info("Created table 'challenge' in the database.");
        } else {
            logger.info("Table 'challenge' already exists.");
        }
    }

}
