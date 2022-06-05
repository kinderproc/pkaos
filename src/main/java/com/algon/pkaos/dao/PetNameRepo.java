package com.algon.pkaos.dao;

import com.algon.pkaos.entity.PetName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetNameRepo extends CrudRepository<PetName, Long> {

    List<PetName> findAll();

    List<PetName> findByPetNameValueContaining(String petNameValue);
}
