package com.driesen.ward.mimic.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * WebConfig configuration class.
 *
 * Contains all the global configurations for enabling spring web functionality.
 */
@Configuration
public class WebConfig {
    /***
     * WebMvcConfigurer is used to enable CORS to specified addresses.
     *
     * @return fully configured WebMvcConfigurer instance.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080");
            }
        };
    }

    /***
     * ModelMapper is used for mapping our own model classes to DTO classes.
     *
     * @return standard ModelMapper instance.
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
