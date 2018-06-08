package it.uniroma3.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.model.Allievo;

public interface AllievoRepository extends CrudRepository<Allievo,Long>{
	
	public List<Allievo> findByNomeAndCognome(String nome, String cognome);
	
	public List<Allievo> findByNomeAndCognomeAndDataNascita(String nome, String cognome, Date dataNascita);
}
