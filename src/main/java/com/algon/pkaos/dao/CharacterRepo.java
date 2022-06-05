package com.algon.pkaos.dao;

import com.algon.pkaos.entity.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepo extends CrudRepository<Character, Long> {

    List<Character> findAll();

    List<Character> findByCharacterValueContaining(String characterValue);
}
