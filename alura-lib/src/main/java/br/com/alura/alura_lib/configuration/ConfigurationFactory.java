package br.com.alura.alura_lib.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import br.com.alura.alura_lib.configuration.annotation.Configuration;

public class ConfigurationFactory {

	@Produces
	@Configuration
	@ApplicationScoped
	public Properties getProperties() throws IOException{
		InputStream inputStream = ConfigurationFactory.class.getResourceAsStream("/alura-lib.properties");
		
		Properties properties = new Properties();
		properties.load(inputStream);
		
		return properties;
	}
	
	
}
