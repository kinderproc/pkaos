package com.algon.pkaos.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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

    @Test
    void generateNickWithFilters() {
        String character = "Good";
        String appearance = "Bald";
        String name = "Amanda";
        String nick = nameGeneratorService.generateNick(character, appearance, name, null, null, null);
        System.out.println(nick);
        assertThat(nick, containsString(character));
        assertThat(nick, containsString(appearance));
        assertThat(nick, containsString(name));
    }
}