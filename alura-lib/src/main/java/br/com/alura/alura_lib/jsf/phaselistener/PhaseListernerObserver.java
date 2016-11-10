package br.com.alura.alura_lib.jsf.phaselistener;

import java.lang.annotation.Annotation;

import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;

import br.com.alura.alura_lib.jsf.phaselistener.annotation.After;
import br.com.alura.alura_lib.jsf.phaselistener.annotation.Before;
import br.com.alura.alura_lib.jsf.phaselistener.annotation.PhaseLiteral;

@SuppressWarnings("serial")
public class PhaseListernerObserver {

	private BeanManager observer = CDI.current().getBeanManager();
	private Annotation momento;
	
	
	public PhaseListernerObserver after(){
		this.momento = new AnnotationLiteral<After>(){};
		return this;
	}
	
	
	public PhaseListernerObserver before(){
		this.momento = new AnnotationLiteral<Before>(){};
		return this;
	}
	
	public void fire(PhaseEvent phaseEvent){
		observer.fireEvent(phaseEvent, momento,new PhaseLiteral(phaseEvent.getPhaseId()) );
	}
	
}
