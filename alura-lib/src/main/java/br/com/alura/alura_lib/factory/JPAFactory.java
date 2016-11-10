package br.com.alura.alura_lib.factory;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.alura_lib.configuration.annotation.Configuration;

@ApplicationScoped
public class JPAFactory {

	private EntityManagerFactory emf;
	
	@Inject	@Configuration
	private Properties properties;
	
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close(@Disposes EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}
	
	@PreDestroy
	public void preDestroy(){
		if (emf.isOpen()) {
			emf.close();
		}
	}

	
	@PostConstruct
	public void loadEMF(){
		
		emf = Persistence
			.createEntityManagerFactory(properties.getProperty("alura.lib.persistenceUnir"));

		
	}
	
}
