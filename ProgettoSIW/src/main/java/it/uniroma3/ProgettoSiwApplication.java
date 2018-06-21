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

	  //Centro 1
	  //Allievi
	  List<Attivita> attivitaAllievo1 = new ArrayList<>();
	  Allievo allievo1 = new Allievo("Giovanni", "Rossi", "dsa@gmail.com", "234567", new Date(), "Crotone", null);

	  List<Attivita> attivitaAllievo2 = new ArrayList<>();
	  Allievo allievo2 = new Allievo("Andrea", "Verdi", "dsa1@gmail.com", "2314567", new Date(), "Crotone", null);


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

	  //Centro 2
	  //Allievi
	  List<Attivita> attivitaAllievo3 = new ArrayList<>();
	  Allievo allievo3 = new Allievo("Matteo", "blu", "dsa@gmail.com", "234567", new Date(), "Crotone", null);

	  List<Attivita> attivitaAllievo4 = new ArrayList<>();
	  Allievo allievo4 = new Allievo("Elia", "Fucsia", "dsa1@gmail.com", "2314567", new Date(), "Crotone", null);


	  List<Attivita> attivitaCentro2 = new ArrayList<>();

	  List<Allievo> allievo3Attivita = new ArrayList<>();
	  List<Allievo> allievo4Attivita = new ArrayList<>();

	  Attivita a3 = new Attivita("attivita 2.1", new Date(), null, null);

	  //aggiungo le attivita all'allievo
	  attivitaAllievo3.add(a3);
	  attivitaAllievo4.add(a3);

	  //aggiungo gli allievi all'attivita
	  allievo3Attivita.add(allievo3);
	  allievo4Attivita.add(allievo4);

	  //aggiungo le attivita al centro
	  attivitaCentro2.add(a3);

	  Attivita a4 = new Attivita("attivita 2.2", new Date(), null, null);

	  //aggiungo le attivita all'allievo
	  attivitaAllievo3.add(a4);
	  attivitaAllievo4.add(a4);

	  //aggiungo gli allievi all'attivita
	  allievo3Attivita.add(allievo3);
	  allievo4Attivita.add(allievo4);
	  //aggiungo le attivita al centro
	  attivitaCentro2.add(a4);

	  //imposto la lista delle attivita al rispettivo allievo
	  allievo3.setAttivita(attivitaAllievo3);
	  allievo4.setAttivita(attivitaAllievo4);

	  //imposto la lista degli allievi alle rispettive attivita
	  a3.setAllievi(allievo3Attivita);
	  a4.setAllievi(allievo4Attivita);


	  Centro c2 = new Centro("Centro Due", "Via oceano2", "dsa@gmail.com", "765432", 100, attivitaCentro1);
	  centroService.save(c2);
	  a3.setCentro(c2);
	  attivitaService.save(a3);
	  a4.setCentro(c2);
	  attivitaService.save(a4);

	  allievoService.save(allievo3);
	  allievoService.save(allievo4);

	 }
}
