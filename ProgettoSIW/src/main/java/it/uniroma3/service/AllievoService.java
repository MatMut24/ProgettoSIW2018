package it.uniroma3.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Allievo;
import it.uniroma3.model.Attivita;
import it.uniroma3.repository.AllievoRepository;

@Transactional
@Service
public class AllievoService {

	@Autowired
	private AllievoRepository allievoRepository;
	
	public Allievo save(Allievo allievo) {
		return this.allievoRepository.save(allievo);
	}
	
	public List<Allievo> findByNome(String nome) {
		return  this.allievoRepository.findByNome(nome);
	}
	
	public Allievo findByNomeAndCognome(String nome, String cognome) {
		return (Allievo) this.allievoRepository.findByNomeAndCognome(nome, cognome);
	}
	
	public Allievo findByNomeAndCognomeAndDataNascita(String nome, String cognome, Date dataNascita) {
		return (Allievo) this.allievoRepository.findByNomeAndCognomeAndDataNascita(nome, cognome, dataNascita);
	}
	
	public List<Allievo> findAll(){
		return (List<Allievo>) this.allievoRepository.findAll();
	}
	
	public Allievo findById(Long id) {
		Optional<Allievo> allievo = this.allievoRepository.findById(id);
		if(allievo.isPresent())
			return allievo.get();
		else
			return null;
	}
	
	public boolean alreadyExists(Allievo allievo) {
		List<Allievo> allievi = this.allievoRepository.findByNomeAndCognomeAndDataNascita(allievo.getNome(), allievo.getCognome(), allievo.getDataNascita());
		if(allievi.size() > 0)
			return true;
		else
			return false;
	}

	public List<Allievo> findByAttivita(Attivita attivita) {
		List<Allievo> listaAllievi = this.allievoRepository.findByAttivita(attivita);
		return listaAllievi;
	}
}
