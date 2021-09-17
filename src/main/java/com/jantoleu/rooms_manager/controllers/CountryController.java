package com.jantoleu.rooms_manager.controllers;

import com.jantoleu.rooms_manager.model.Country;
import com.jantoleu.rooms_manager.repository.CountryRepository;
import com.jantoleu.rooms_manager.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping("/api/country")
    public List<Country> getCountries() {
        List<Country> countries =  countryService.getAllCountries();
        return countries;
    }
}
