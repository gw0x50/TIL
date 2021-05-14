package com.multi.myboot01;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**") // URL 설정
                .addResourceLocations("file:///Users/melonbottle/upload/");
        registry.addResourceHandler("/faceimages/**")
        		.addResourceLocations("file:///Users/melonbottle/images/"); 
    }
}


