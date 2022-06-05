package com.algon.pkaos.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pet_name")
@SuppressWarnings("unused")
public class PetName {

    @Id
    @GeneratedValue
    @Column(name = "pet_name_id")
    private long id;

    @Column(name = "pet_name_value", nullable = false)
    private String petNameValue;

    public PetName() {
    }

    public PetName(long id, String petNameValue) {
        this.id = id;
        this.petNameValue = petNameValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPetNameValue() {
        return petNameValue;
    }

    public void setPetNameValue(String petNameValue) {
        this.petNameValue = petNameValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetName petName = (PetName) o;
        return id == petName.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
