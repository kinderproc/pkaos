package com.algon.pkaos.service.impl;

import com.algon.pkaos.dictionary.NameDictionary;
import com.algon.pkaos.service.NickGeneratorService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NickGeneratorServiceImpl implements NickGeneratorService {

    private String randomElement(List<String> list) {
        int index = (int) Math.floor(Math.random() * list.size());
        return list.get(index);
    }

    @Override
    public String generateNick() {
        return generateNick(null, null, null, null, null, null);
    }

    @Override
    public String generateNick(String character, String appearance, String name, String gender, String group, String color) {
        List<String> filteredCharacters = NameDictionary.CHARACTERS.stream()
                .filter(e -> Strings.isEmpty(character) || e.contains(character))
                .collect(Collectors.toList());
        List<String> filteredAppearances = NameDictionary.APPEARANCES.stream()
                .filter(e -> Strings.isEmpty(appearance) || e.contains(appearance))
                .collect(Collectors.toList());
        List<String> filteredNames = NameDictionary.NAMES.stream()
                .filter(e -> Strings.isEmpty(name) || e.contains(name))
                .collect(Collectors.toList());
        return randomElement(filteredCharacters) +
                randomElement(filteredAppearances) +
                randomElement(filteredNames);
    }
}