package br.com.alura.alura_lib.factory;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.alura.alura_lib.dao.DAO;

@SuppressWarnings("unchecked")
public class DAOFactory {

	@Inject
	private EntityManager manger;

	@Produces
	public <T> DAO<T> factory(InjectionPoint point){
		
		ParameterizedType type = (ParameterizedType) point.getType();
		
		Class<T> classe = (Class<T>) type.getActualTypeArguments()[0];
		return new DAO<T>(classe, manger);
	}
	
}
