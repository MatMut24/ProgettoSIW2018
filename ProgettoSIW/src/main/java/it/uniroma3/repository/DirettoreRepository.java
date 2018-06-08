package it.uniroma3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Direttore;

public interface DirettoreRepository extends CrudRepository<Direttore,Long>{
	
	public List<Direttore> findByNome(String nome);
	
}
