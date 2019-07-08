package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EShopManagerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShopManagerAppApplication.class, args);
	}

	
	
	/*
	 * @Bean public WebMvcConfigurer corsConfigurer() { return new
	 * WebMvcConfigurerAdapter() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**").allowedMethods("*").allowedOrigins("*"); } }; }
	 */

}
