package br.com.alura.alura_lib.helper;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;

public class MessageHelper implements Serializable{
	
	
	private static final long serialVersionUID = -343495439544517197L;
	
	private FacesContext context;
	private Flash flash;
	
	@Inject
	public MessageHelper(FacesContext context, Flash flash){
		this.context = context;
		this.flash = flash;
	}

	
	public MessageHelper onFlash(){
		flash.setKeepMessages(true);
		return this;
	}
	
	public void addMessage(FacesMessage message){
		addMessage(null, message);
	}

	public void addMessage(String clientId, FacesMessage message) {
		context.addMessage(clientId, message);
	}

}
