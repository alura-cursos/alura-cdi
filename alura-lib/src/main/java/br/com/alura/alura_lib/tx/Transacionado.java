package br.com.alura.alura_lib.tx;

import java.io.Serializable;

import javax.interceptor.InvocationContext;

public interface Transacionado extends Serializable{
	Object executaComTransacao(InvocationContext context);
}
