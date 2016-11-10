package br.com.alura.livraria.util;

import javax.enterprise.event.Observes;
import javax.faces.event.PhaseEvent;

import br.com.alura.alura_lib.jsf.phaselistener.annotation.Before;

public class LogPhase {
	
	public void log( @Observes @Before PhaseEvent phaseEvent){
		System.out.println("FASE: " + phaseEvent.getPhaseId());
	}

}
