package it.uniroma3.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.model.Attivita;
import it.uniroma3.model.Centro;
import it.uniroma3.service.AttivitaService;
import it.uniroma3.service.CentroService;

@Controller
public class CentroController {

	@Autowired
	private CentroService centroService;
	
	//gestioneCentro
		@RequestMapping("/gestioneCentro")
		public String gestioneCentro(Model model) {
			return "gestioneCentro";
		}

	//Centri
	@RequestMapping("/centri")
	public String centri(Model model) {
		model.addAttribute("centri", centroService.findAll());
		return "centroList";
	}
	//sceglicentro
	@RequestMapping("/scegliCentro")
	public String scegliCentro(Model model) {
		model.addAttribute("centri", centroService.findAll());
		return "scegliCentro";
	}
	
	//centroScelto
	@RequestMapping(value = "/centroScelto/{id}", method = RequestMethod.GET)
	public String getCentroScelto(@PathVariable("id") Long id, Model model) {
		model.addAttribute("centro", this.centroService.findById(id));
		return "addAttivitaToCentro";
	}
	
	//getCentro
	@RequestMapping(value = "/centro/{id}", method = RequestMethod.GET)
	public String getCentro(@PathVariable("id") Long id, Model model) {
		model.addAttribute("centro", this.centroService.findById(id));
		return "showCentro";
	}
}
