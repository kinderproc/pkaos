package com.algon.pkaos.service.impl;

import com.algon.pkaos.dictionary.NameDictionary;
import com.algon.pkaos.service.NickGeneratorService;

public class NickGeneratorServiceImpl implements NickGeneratorService {

    private String randomElement(String[] arr) {
        int index = (int) Math.floor(Math.random() * arr.length);
        return arr[index];
    }

    @Override
    public String generateNick() {
        return randomElement(NameDictionary.CHARACTER) +
                randomElement(NameDictionary.APPEARANCE) +
                randomElement(NameDictionary.NAME);
    }
}
