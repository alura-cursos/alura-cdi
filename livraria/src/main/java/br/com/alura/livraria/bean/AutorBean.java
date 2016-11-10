package br.com.alura.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.alura.alura_lib.dao.DAO;
import br.com.alura.alura_lib.tx.annotation.Transacional;
import br.com.alura.livraria.modelo.Autor;



@Named
@RequestScoped
public class AutorBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Autor autor = new Autor();
	
	private Integer autorId;

	private DAO<Autor> autorDao;

	@Inject
	public AutorBean(DAO<Autor> autorDao){
		this.autorDao = autorDao;
	}
	
		
	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public void carregarAutorPelaId() {
		this.autor = autorDao.buscaPorId(autorId);
	}

	@Transacional
	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if(this.autor.getId() == null) {
			autorDao.adiciona(this.autor);
		} else {
			autorDao.atualiza(this.autor);
		}

		this.autor = new Autor();

		return "livro?faces-redirect=true";
	}
	
	@Transacional
	public void remover(Autor autor) {
		System.out.println("Removendo autor " + autor.getNome());
		autorDao.remove(autor);
	}
	
	public List<Autor> getAutores() {
		return autorDao.listaTodos();
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
