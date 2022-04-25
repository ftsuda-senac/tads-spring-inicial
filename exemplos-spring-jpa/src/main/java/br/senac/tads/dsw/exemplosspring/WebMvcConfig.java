package br.senac.tads.dsw.exemplosspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${app.imagem-path}")
    private String imagemPath;

    @Value("${app.imagem-url-prefix}")
    private String imagemUrlPrefix;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(imagemUrlPrefix + "/**")
                .addResourceLocations("file:///" + imagemPath);
    }

}
