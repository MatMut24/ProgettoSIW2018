package it.uniroma3;

import java.util.Date;

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
		Allievo allievo = new Allievo("Giovanni", "Rossi", "dsa@gmail.com", "234567", new Date(), "Crotone");
		allievoService.save(allievo);
		Centro c1 = new Centro("Centro Uno", "Via oceano1", "dsa@gmail.com", "234567", 100);
		centroService.save(c1);
		Attivita a1 = new Attivita("attivita 1", new Date());
		attivitaService.save(a1);
		Attivita a2 = new Attivita("attivita 2", new Date());
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
		centroService.save(c6);
	}
}
