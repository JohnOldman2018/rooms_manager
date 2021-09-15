package com.jantoleu.rooms_manager.repository;

import com.jantoleu.rooms_manager.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {
    List<Country> findAll();
}
