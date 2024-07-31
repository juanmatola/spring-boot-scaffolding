package com.athomic.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Configuration class for setting up application configs, beans, etc.
 */
@Configuration
public class ApplicationConfig {

    /**
     * Bean definition for {@link ObjectMapper}.
     * <p>
     * This method creates and configures an instance of {@link ObjectMapper} with a custom {@link JavaTimeModule}
     * that includes a serializer for {@link LocalDateTime}. The serializer formats {@link LocalDateTime} using
     * {@link DateTimeFormatter#ISO_LOCAL_DATE_TIME}.
     * </p>
     *
     * @return a configured {@link ObjectMapper} instance
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }
}
