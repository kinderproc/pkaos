package com.algon.pkaos.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "appearance")
@SuppressWarnings("unused")
public class Appearance {

    @Id
    @GeneratedValue
    @Column(name = "appearance_id")
    private long id;

    @Column(name = "appearance_value", nullable = false)
    private String appearanceValue;

    public Appearance() {
    }

    public Appearance(long id, String appearanceValue) {
        this.id = id;
        this.appearanceValue = appearanceValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAppearanceValue() {
        return appearanceValue;
    }

    public void setAppearanceValue(String appearanceValue) {
        this.appearanceValue = appearanceValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appearance that = (Appearance) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
