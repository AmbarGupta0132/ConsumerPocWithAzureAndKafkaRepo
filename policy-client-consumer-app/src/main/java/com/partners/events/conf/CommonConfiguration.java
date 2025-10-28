package com.partners.events.conf;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Configuration class for common application beans.
 * Provides a {@link ModelMapper} bean for object mapping.
 */
@Configuration
public class CommonConfiguration {

    /**
     * Creates and provides a {@link ModelMapper} bean.
     *
     * @return a new instance of ModelMapper
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}