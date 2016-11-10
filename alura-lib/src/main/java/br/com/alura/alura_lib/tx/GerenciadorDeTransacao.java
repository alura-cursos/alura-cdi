package br.com.alura.alura_lib.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.alura.alura_lib.tx.annotation.Transacional;


@Interceptor
@Transacional
public class GerenciadorDeTransacao implements Serializable {

	private static final long serialVersionUID = -1392064408660679407L;
	
	private EntityManager em;
	
	@Inject
	public GerenciadorDeTransacao(EntityManager em){
		this.em = em;
	}
	

	@AroundInvoke
	public Object executaComTransacao(InvocationContext context) {
		em.getTransaction().begin();
		
		try {
			Object resultado = context.proceed();
			
			em.getTransaction().commit();
			
			return resultado;
		} catch (Exception e) {
			em.getTransaction().rollback();
			
			throw new RuntimeException(e);
		}

	}

}
