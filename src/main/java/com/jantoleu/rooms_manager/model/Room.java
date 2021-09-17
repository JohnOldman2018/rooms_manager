package com.jantoleu.rooms_manager.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
public class Room {
    @Id
    private Integer id;
    private String name;
    private String countryCode;
    private Boolean lightIsOn;
}
