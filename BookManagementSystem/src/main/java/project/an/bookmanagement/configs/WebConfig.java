package project.an.bookmanagement.configs;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.annotation.PostConstruct;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	/*
	 * @Value("${upload.dir}") private String uploadDir;
	 * 
	 * @PostConstruct public void init() { System.out.println(">>> uploadDir = " +
	 * uploadDir); }
	 * 
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * String absolutePath = Paths.get(uploadDir).toFile().getAbsolutePath();
	 * registry.addResourceHandler("/uploads/**") .addResourceLocations("file:" +
	 * absolutePath + "/"); }
	 */
}
