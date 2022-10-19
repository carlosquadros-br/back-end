package com.project.backend;

import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MongoConnectionApplicationLiveTest {
    private static final String HOST = "localhost";
    private static final String PORT = "27017";
    private static final String DB = "users";
    private static final String USER = "admin";
    private static final String PASS = "password";

    // test cases

    private void assertInsertSucceeds(ConfigurableApplicationContext context) {
        String name = "A";

        MongoTemplate mongo = context.getBean(MongoTemplate.class);
        Document doc = Document.parse("{\"name\":\"" + name + "\"}");
        Document inserted = mongo.insert(doc, "items");

        assertNotNull(inserted.get("_id"));
        assertEquals(inserted.get("name"), name);
    }

}