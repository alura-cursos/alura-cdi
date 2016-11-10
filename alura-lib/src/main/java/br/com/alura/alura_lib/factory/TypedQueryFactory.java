package br.com.alura.alura_lib.factory;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.alura_lib.jpa.annotation.Query;

public class TypedQueryFactory {

	@Inject
	private EntityManager em;

	@Produces
	@Query("")
	public <X> TypedQuery<X> factory(InjectionPoint point){
		
		ParameterizedType type = (ParameterizedType) point.getType();
		
		@SuppressWarnings("unchecked")
		Class<X> classe = (Class<X>) type.getActualTypeArguments()[0];
		
		String jpql = point.getAnnotated().getAnnotation(Query.class).value();
		return em.createQuery(jpql, classe);
	}
	
}
