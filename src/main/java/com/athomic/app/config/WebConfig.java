package com.athomic.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Configuration class for setting up web-related configurations including CORS and formatters.
 * <p>
 * This class implements {@link WebMvcConfigurer} to customize web-related settings for the application.
 * It configures CORS settings to allow requests from any origin and sets up a custom formatter for {@link LocalDateTime}.
 * </p>
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configures CORS mappings for the application.
     * <p>
     * This method allows requests from any origin and permits HTTP methods GET, POST, PUT, DELETE, and OPTIONS.
     * It also allows all headers and supports credentials.
     * </p>
     *
     * @param registry the {@link CorsRegistry} to configure
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    /**
     * Adds custom formatters to the application's formatter registry.
     * <p>
     * This method registers a custom formatter for {@link LocalDateTime} that uses the ISO_LOCAL_DATE_TIME format.
     * </p>
     *
     * @param registry the {@link FormatterRegistry} to configure
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(LocalDateTime.class, new LocalDateTimeFormatter());
    }

    /**
     * Custom formatter for {@link LocalDateTime}.
     * <p>
     * This inner class provides methods to parse and print {@link LocalDateTime} using the ISO_LOCAL_DATE_TIME format.
     * </p>
     */
    private static class LocalDateTimeFormatter implements Formatter<LocalDateTime> {

        /**
         * Parses a {@link String} into a {@link LocalDateTime} using the ISO_LOCAL_DATE_TIME format.
         *
         * @param text   the {@link String} to parse
         * @param locale the {@link Locale} to use
         * @return the parsed {@link LocalDateTime}
         * @throws DateTimeParseException if the text cannot be parsed
         */
        @Override
        public LocalDateTime parse(String text, Locale locale) throws DateTimeParseException {
            return LocalDateTime.parse(text, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }

        /**
         * Prints a {@link LocalDateTime} as a {@link String} using the ISO_LOCAL_DATE_TIME format.
         *
         * @param object the {@link LocalDateTime} to print
         * @param locale the {@link Locale} to use
         * @return the formatted {@link String}
         */
        @Override
        public String print(LocalDateTime object, Locale locale) {
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(object);
        }
    }

}