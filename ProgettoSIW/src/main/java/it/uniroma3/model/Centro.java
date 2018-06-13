package it.uniroma3.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Centro {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column
	private String indirizzo;
	
	@Column
	private String email;
	
	@Column
	private String telefono;
	
	@Column
	private int allieviMax;
	
	@OneToMany(mappedBy="centro")
	private List<Attivita> attivita;
	
	public Centro() {

	}

	public Centro(String nome, String indirizzo, String email, String telefono, int allieviMax, List<Attivita> attivita) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.email = email;
		this.telefono = telefono;
		this.allieviMax = allieviMax;
		this.attivita = attivita;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getAllieviMax() {
		return allieviMax;
	}

	public void setAllieviMax(int allieviMax) {
		this.allieviMax = allieviMax;
	}

	public List<Attivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(List<Attivita> attivita) {
		this.attivita = attivita;
	}
	
	
	
	
}
