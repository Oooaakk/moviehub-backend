package com.example.moviehub.service.Impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RedisServiceImplTest {

    @Autowired
    RedisServiceImpl redisService;

    private final String  key = "testKey";
    private final String  value = "12345";

    @Test
    @Order(1)
    void setString() {
        redisService.setString(key, value);
    }

    @Test
    @Order(2)
    void getString() {
        Assert.notNull(redisService.getString(key), "No value found");
    }

    @Test
    @Order(3)
    void existKey() {
        Assert.isTrue(redisService.existKey(key), "Key not exist");
    }

    @Test
    @Order(5)
    void updateString() {
        redisService.updateString(key, "54321");
    }

    @Test
    @Order(4)
    void verifyCode() {
        Assert.isTrue(redisService.verifyCode(key, value), "Wrong Code");
    }
}