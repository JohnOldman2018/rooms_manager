package com.jantoleu.rooms_manager.service;

import com.jantoleu.rooms_manager.model.Country;
import com.jantoleu.rooms_manager.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
