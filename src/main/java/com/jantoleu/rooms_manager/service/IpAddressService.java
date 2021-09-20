package com.jantoleu.rooms_manager.service;

import com.jantoleu.rooms_manager.model.Country;
import com.jantoleu.rooms_manager.model.IpCountry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@AllArgsConstructor
@Service
public class IpAddressService {

    private RestTemplate restTemplate;

    public String getCountryCodeByIp (String ip) {
        try {
            IpCountry country = restTemplate.getForObject(new URI("http://ip-api.com/json/" + ip), IpCountry.class);
            return country.getCountryCode();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return "";
        }

    }

}
