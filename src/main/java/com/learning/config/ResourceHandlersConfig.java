package com.learning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.learning.utils.GlobalPathUtils;

@Configuration
public class ResourceHandlersConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(GlobalPathUtils.fileClientPath)
                .addResourceLocations("file:" + GlobalPathUtils.fileServerPath);
    }

}