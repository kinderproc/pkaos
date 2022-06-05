package com.algon.pkaos.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "character")
@SuppressWarnings("unused")
public class Character {

    @Id
    @GeneratedValue
    @Column(name = "character_id")
    private long id;

    @Column(name = "character_value", nullable = false)
    private String characterValue;

    public Character() {
    }

    public Character(long id, String characterValue) {
        this.id = id;
        this.characterValue = characterValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCharacterValue() {
        return characterValue;
    }

    public void setCharacterValue(String characterValue) {
        this.characterValue = characterValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id == character.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
