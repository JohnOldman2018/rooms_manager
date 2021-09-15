package com.jantoleu.rooms_manager.controllers;

import com.jantoleu.rooms_manager.model.Country;
import com.jantoleu.rooms_manager.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CountryController {

    private final CountryRepository countryRepository;

    @GetMapping("/api/country")
    public List<Country> getCountries() {
        List<Country> c = countryRepository.findAll();
        log.info("Countries", c);
        return c;
    }
}
