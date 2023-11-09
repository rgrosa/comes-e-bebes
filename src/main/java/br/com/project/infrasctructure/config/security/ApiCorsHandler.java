package br.com.project.infrasctructure.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ApiCorsHandler extends WebMvcConfigurerAdapter {

    @Override
	public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**")
            .allowedMethods("GET", "POST", "PUT", "OPTIONS")
            .allowedHeaders("*")
            .allowedOrigins("*");
    }
}
