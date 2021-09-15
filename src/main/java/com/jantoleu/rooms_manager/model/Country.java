package com.jantoleu.rooms_manager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Accessors(chain = true)
public class Country {
    @Id
    private String code;
    private String name;
}
