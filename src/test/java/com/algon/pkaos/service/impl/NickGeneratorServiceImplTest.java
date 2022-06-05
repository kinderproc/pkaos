package com.algon.pkaos.service.impl;

import com.algon.pkaos.dao.AppearanceRepo;
import com.algon.pkaos.dao.CharacterRepo;
import com.algon.pkaos.dao.PetNameRepo;
import com.algon.pkaos.entity.Appearance;
import com.algon.pkaos.entity.Character;
import com.algon.pkaos.entity.PetName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

@SpringBootTest
class NickGeneratorServiceImplTest {

    @Mock
    AppearanceRepo appearanceRepo;

    @Mock
    CharacterRepo characterRepo;

    @Mock
    PetNameRepo petNameRepo;

    @InjectMocks
    NickGeneratorServiceImpl nameGeneratorService;

    private List<Character> CHARACTERS = new ArrayList<>();

    private List<Appearance> APPEARANCES = new ArrayList<>();

    private List<PetName> PET_NAMES = new ArrayList<>();

    @BeforeEach
    void setUp() {
        CHARACTERS = Arrays.asList(
                new Character(1L, "Good"),
                new Character(2L, "Bad"),
                new Character(3L, "Evil"),
                new Character(4L, "Bold")
        );

        APPEARANCES = Arrays.asList(
                new Appearance(1L, "Plump"),
                new Appearance(2L, "Skinny"),
                new Appearance(3L, "Three-Legged"),
                new Appearance(4L, "Toothless")
        );

        PET_NAMES = Arrays.asList(
                new PetName(1L, "Dingo"),
                new PetName(2L, "Chip"),
                new PetName(3L, "Aliot"),
                new PetName(4L, "Hazel")
        );
    }

    @Test
    void generateNick() {
        when(appearanceRepo.findAll()).thenReturn(APPEARANCES);
        when(characterRepo.findAll()).thenReturn(CHARACTERS);
        when(petNameRepo.findAll()).thenReturn(PET_NAMES);

        String nick = nameGeneratorService.generateNick();
        System.out.println(nick);

        assertFalse(nick.isEmpty());
        assertTrue(nick.length() > 6);
    }

    @Test
    void generateNickWithFilters() {
        Character character = new Character(1L, "Good");
        Appearance appearance = new Appearance(1L, "Skinny");
        PetName petName = new PetName(1L, "Hazel");

        when(appearanceRepo.findByAppearanceValueContaining(appearance.getAppearanceValue()))
                .thenReturn(Collections.singletonList(appearance));
        when(characterRepo.findByCharacterValueContaining(character.getCharacterValue()))
                .thenReturn(Collections.singletonList(character));
        when(petNameRepo.findByPetNameValueContaining(petName.getPetNameValue()))
                .thenReturn(Collections.singletonList(petName));

        String nick = nameGeneratorService.generateNick(character.getCharacterValue(), appearance.getAppearanceValue(),
                petName.getPetNameValue());
        System.out.println(nick);

        assertThat(nick, containsString(character.getCharacterValue()));
        assertThat(nick, containsString(appearance.getAppearanceValue()));
        assertThat(nick, containsString(petName.getPetNameValue()));
    }
}