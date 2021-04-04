package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



@SpringBootApplication
public class ECareBackendPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECareBackendPocApplication.class, args);
	System.out.println("äpplication started");
	}

	
	@Bean
	public CorsFilter corsFilter() {
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	CorsConfiguration config = new CorsConfiguration();
	//config.setAllowCredentials(true);
	config.addAllowedOrigin("*");
	config.addAllowedHeader("*");
	config.addAllowedMethod("OPTIONS");
	config.addAllowedMethod("GET");
	config.addAllowedMethod("POST");
	config.addAllowedMethod("PUT");
	config.addAllowedMethod("DELETE");
	source.registerCorsConfiguration("/**", config);
	return new CorsFilter(source);
	}
	/*
	 * @Bean CommandLineRunner runner(eCareIncidentService eCareIncidentService) {
	 * return args -> { // read json and write to db ObjectMapper mapper = new
	 * ObjectMapper(); TypeReference<ArrayList<ECareIncidentDetails>> typeReference
	 * = new TypeReference<ArrayList<ECareIncidentDetails>>(){}; //InputStream
	 * inputStream = TypeReference.class.getResourceAsStream("incidents.json");
	 * Resource resource = new ClassPathResource("Json/incidents.json");
	 * 
	 * InputStream inputStream = resource.getInputStream(); try {
	 * List<ECareIncidentDetails> incidents =
	 * mapper.readValue(inputStream,typeReference);
	 * eCareIncidentService.save(incidents); System.out.println("Users Saved!"); }
	 * catch (IOException e){ System.out.println("Unable to save users: " +
	 * e.getMessage()); } }; }
	 */
}
