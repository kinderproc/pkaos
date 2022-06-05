package com.algon.pkaos.dao;

import com.algon.pkaos.entity.Appearance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppearanceRepo extends CrudRepository<Appearance, Long> {

    List<Appearance> findAll();

    List<Appearance> findByAppearanceValueContaining(String appearanceValue);
}
