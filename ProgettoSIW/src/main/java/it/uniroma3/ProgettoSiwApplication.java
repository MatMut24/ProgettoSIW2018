package it.uniroma3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.uniroma3.model.Allievo;
import it.uniroma3.model.Attivita;
import it.uniroma3.model.Centro;
import it.uniroma3.service.AllievoService;
import it.uniroma3.service.AttivitaService;
import it.uniroma3.service.CentroService;


@SpringBootApplication
public class ProgettoSiwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSiwApplication.class, args);
	}
	
	@Autowired
	private AllievoService allievoService;
	
	@Autowired
	private CentroService centroService;
	
	@Autowired
	private AttivitaService attivitaService;
	
	@PostConstruct
	public void init() {
		
		//Allievi
		List<Attivita> attivitaAllievo1 = new ArrayList<>();
		Allievo allievo1 = new Allievo("Giovanni", "Rossi", "dsa@gmail.com", "234567", new Date(), "Crotone", null);
		
		List<Attivita> attivitaAllievo2 = new ArrayList<>();
		Allievo allievo2 = new Allievo("Andrea", "Verdi", "dsa1@gmail.com", "2314567", new Date(), "Crotone", null);
		
		
		//Centro 1
		List<Attivita> attivitaCentro1 = new ArrayList<>();
		
		List<Allievo> allievo1Attivita = new ArrayList<>();
		List<Allievo> allievo2Attivita = new ArrayList<>();
		
		Attivita a1 = new Attivita("attivita 1.1", new Date(), null, null);
		
		//aggiungo le attivita all'allievo
		attivitaAllievo1.add(a1);
		attivitaAllievo2.add(a1);
		
		//aggiungo gli allievi all'attivita
		allievo1Attivita.add(allievo1);
		allievo1Attivita.add(allievo2);
		
		//aggiungo le attivita al centro
		attivitaCentro1.add(a1);
		
		Attivita a2 = new Attivita("attivita 1.2", new Date(), null, null);
		
		//aggiungo le attivita all'allievo
		attivitaAllievo1.add(a2);
		
		//aggiungo gli allievi all'attivita
		allievo2Attivita.add(allievo1);
		
		//aggiungo le attivita al centro
		attivitaCentro1.add(a2);
		
		//imposto la lista delle attivita al rispettivo allievo
		allievo1.setAttivita(attivitaAllievo1);
		allievo2.setAttivita(attivitaAllievo2);
		
		//imposto la lista degli allievi alle rispettive attivita
		a1.setAllievi(allievo1Attivita);
		a2.setAllievi(allievo2Attivita);
		

		Centro c1 = new Centro("Centro Uno", "Via oceano1", "dsa@gmail.com", "234567", 100, attivitaCentro1);
		centroService.save(c1);
		a1.setCentro(c1);
		attivitaService.save(a1);
		a2.setCentro(c1);
		attivitaService.save(a2);
		
		allievoService.save(allievo1);
		allievoService.save(allievo2);
		
		
		/*//Centro 2
		List<Attivita> a3 = new ArrayList<>();
		Attivita a4 = new Attivita("attivita 2.1", new Date(), null, null);
		a3.add(a4);
		Attivita a5 = new Attivita("attivita 2.2", new Date(), null, null);
		a3.add(a5);
		Centro c2 = new Centro("Centro Due", "Via oceano1", "dsa@gmail.com", "234567", 100, attivitaCentro1);
		centroService.save(c2);
		a4.setCentro(c2);
		attivitaService.save(a4);
		a5.setCentro(c2);
		attivitaService.save(a5);*/
		/*Attivita a2 = new Attivita("attivita 2", new Date());
		attivitaService.save(a2);
		Centro c2 = new Centro("Centro Due", "Via oceano2", "dsa@gmail.com", "234567", 100);
		centroService.save(c2);
		Centro c3 = new Centro("Centro Tre", "Via oceano3", "dsa@gmail.com", "234567", 100);
		centroService.save(c3);
		Centro c4 = new Centro("Centro Quattro", "Via oceano4", "dsa@gmail.com", "234567", 100);
		centroService.save(c4);
		Centro c5 = new Centro("Centro Cinque", "Via oceano5", "dsa@gmail.com", "234567", 100);
		centroService.save(c5);
		Centro c6 = new Centro("Centro Sei", "Via oceano6", "dsa@gmail.com", "234567", 100);
		centroService.save(c6);*/
	}
}
