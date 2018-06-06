package it.uniroma3.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Azienda {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	@JoinColumn(name="azienda_id")
	private Map<String,Centro> centri;
	
	@OneToMany
	@JoinColumn(name="azienda_id")
	private Map<String,Allievo> allievi;
	
	@OneToMany
	@JoinColumn(name="azienda_id")
	private List<Responsabile> responsabili;
	
	@OneToMany(mappedBy="azienda")
	private List<Direttore> direttori;

	public Azienda() {

	}

	public Long getId() {
		return id;
	}
	
	public Map<String, Centro> getCentri() {
		return centri;
	}

	public void setCentri(Map<String, Centro> centri) {
		this.centri = centri;
	}
	
	
}
