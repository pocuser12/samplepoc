package com.poc.config;  
  
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
  /*
   * 
   * configuration class that can be accessed from anywhere to get the configured properties in application. 
   */
@Configuration 
@ComponentScan("com.poc") 
@EnableWebMvc   
public class AppConfig {  
	@SuppressWarnings("serial")
	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	
	
	@Value("${service.url}")
	private String serviceURL;


	public String getServiceURL() {
		return serviceURL;
	}


	public void setServiceURL(String serviceURL) {
		this.serviceURL = serviceURL;
	}
	
	
	
	
}  
