package com.mgptech.api.myrestapi.services.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurityConfig  {

    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer(){

            @Override
            public void addCorsMappings(CorsRegistry corsRegistry){
                corsRegistry.addMapping("/**")
                        .allowedMethods("GET","POST","PUT","PATCH","DELETE")
                        .allowedHeaders("*")
                        .allowedOrigins("*");
            }
        };
    }



}
