package br.com.alura.alura_lib.jsf.phaselistener.annotation;

import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseId;

public class PhaseLiteral extends AnnotationLiteral<Phase> implements Phase {

	

	private static final long serialVersionUID = 3320747441506123437L;
	
	private Phases phases;

	public PhaseLiteral(PhaseId phaseId) {
		phases = Phase.Phases.valueOf(phaseId.getName());
	}

	@Override
	public Phases value() {
		
		return phases;
	}

}
