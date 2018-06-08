package it.uniroma3.model;

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
	private String Indirizzo;
	
	@Column
	private String email;
	
	@Column
	private String telefono;
	
	@Column
	private int allieviMax;
	
	@OneToMany(mappedBy="centro")
	private Map<String,Attivita> attivita;
	
	public Centro() {

	}

	public Centro(String nome, String indirizzo, String email, String telefono, int allieviMax) {
		this.nome = nome;
		Indirizzo = indirizzo;
		this.email = email;
		this.telefono = telefono;
		this.allieviMax = allieviMax;
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
		return Indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
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

	public Map<String, Attivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(Map<String, Attivita> attivita) {
		this.attivita = attivita;
	}
	
	
	
	
}
