package com.peekaboo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource( value = "file:c:/dev/config.properties", ignoreResourceNotFound = true ),
    @PropertySource( value = "file:${user.home}/env/config.properties", ignoreResourceNotFound = true)
})
public class GlobalPropertySource {

	@Value("${spring.datasource.hikari.driver-class-name}")
	private String driverClassName;
	
    @Value("${spring.datasource.hikari.jdbc-url}")
    private String url;
    
    @Value("${spring.datasource.hikari.username}")
    private String username;
    
    @Value("${spring.datasource.hikari.password}")
    private String password;
 
    public String getDriverClassName() {
        return driverClassName;
    }
 
    public String getUrl() {
        return url;
    }
 
    public String getUsername() {
        return username;
    }
 
    public String getPassword() {
        return password;
    }
}
