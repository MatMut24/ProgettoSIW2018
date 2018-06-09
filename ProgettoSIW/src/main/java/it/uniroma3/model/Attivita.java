package it.uniroma3.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Attivita {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@ManyToMany(mappedBy="attivita")
	private Map<String,Allievo> allievi;
	
	@ManyToOne
	private Centro centro;

	public Attivita() {
		
	}

	public Attivita(String nome, Date data) {
		this.nome = nome;
		this.data = data;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Map<String, Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(Map<String, Allievo> allievi) {
		this.allievi = allievi;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}
}
