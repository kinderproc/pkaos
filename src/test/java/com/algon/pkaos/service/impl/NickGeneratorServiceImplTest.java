package com.algon.pkaos.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NickGeneratorServiceImplTest {

    NickGeneratorServiceImpl nameGeneratorService;

    @BeforeEach
    void setUp() {
        nameGeneratorService = new NickGeneratorServiceImpl();
    }

    @Test
    void generateNick() {
        String nick = nameGeneratorService.generateNick();
        System.out.println(nick);
        assertFalse(nick.isEmpty());
        assertTrue(nick.length() > 6);
    }
}