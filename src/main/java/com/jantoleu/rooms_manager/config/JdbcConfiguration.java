package com.jantoleu.rooms_manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.Collections;

@Configuration
public class JdbcConfiguration extends AbstractJdbcConfiguration {

    @Override
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(Collections.singletonList(TinyintToBooleanConverter.INSTANCE));
    }

    @ReadingConverter
    enum TinyintToBooleanConverter implements Converter<Byte, Boolean> {
        INSTANCE;
        @Override
        public Boolean convert(Byte source) {
            return source == 1;
        }
    }
}