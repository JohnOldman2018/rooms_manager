package com.jantoleu.rooms_manager.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Country {
    @Id
    private String code;
    private String name;
}
