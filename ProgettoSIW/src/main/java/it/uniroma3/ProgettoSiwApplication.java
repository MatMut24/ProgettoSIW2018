package it.uniroma3;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.uniroma3.model.Allievo;
import it.uniroma3.service.AllievoService;


@SpringBootApplication
public class ProgettoSiwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSiwApplication.class, args);
	}
	
	@Autowired
	private AllievoService allievoService;
	
	@PostConstruct
	public void init() {
		Allievo allievo = new Allievo("Giovanni", "Rossi", "dsa@gmail.com", "234567", new Date(), "Crotone");
		allievoService.save(allievo);
		for(Allievo a : allievoService.findByNome("Giovanni")) {
			System.out.println(a.getNome());
		}
	}
}
