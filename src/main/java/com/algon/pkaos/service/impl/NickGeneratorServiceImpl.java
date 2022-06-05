package com.algon.pkaos.service.impl;

import com.algon.pkaos.dao.AppearanceRepo;
import com.algon.pkaos.dao.CharacterRepo;
import com.algon.pkaos.dao.PetNameRepo;
import com.algon.pkaos.entity.Appearance;
import com.algon.pkaos.entity.Character;
import com.algon.pkaos.entity.PetName;
import com.algon.pkaos.service.NickGeneratorService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NickGeneratorServiceImpl implements NickGeneratorService {

    private final AppearanceRepo appearanceRepo;
    private final CharacterRepo characterRepo;
    private final PetNameRepo petNameRepo;

    public NickGeneratorServiceImpl(AppearanceRepo appearanceRepo, CharacterRepo characterRepo, PetNameRepo petNameRepo) {
        this.appearanceRepo = appearanceRepo;
        this.characterRepo = characterRepo;
        this.petNameRepo = petNameRepo;
    }

    private String randomElement(List<String> list) {
        int index = (int) Math.floor(Math.random() * list.size());
        return list.get(index);
    }

    @Override
    public String generateNick() {
        return generateNick(null, null, null);
    }

    @Override
    public String generateNick(String character, String appearance, String petName) {
        List<String> characters =
                (Strings.isEmpty(character) ? characterRepo.findAll() : characterRepo.findByCharacterValueContaining(character))
                        .stream()
                        .map(Character::getCharacterValue)
                        .collect(Collectors.toList());
        List<String> appearances =
                (Strings.isEmpty(appearance) ? appearanceRepo.findAll() : appearanceRepo.findByAppearanceValueContaining(appearance))
                        .stream()
                        .map(Appearance::getAppearanceValue)
                        .collect(Collectors.toList());
        List<String> petNames =
                (Strings.isEmpty(petName) ? petNameRepo.findAll() : petNameRepo.findByPetNameValueContaining(petName))
                        .stream()
                        .map(PetName::getPetNameValue)
                        .collect(Collectors.toList());

        return randomElement(characters) +
                randomElement(appearances) +
                randomElement(petNames);
    }
}