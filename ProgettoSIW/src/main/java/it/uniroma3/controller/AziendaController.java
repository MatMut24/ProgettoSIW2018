package it.uniroma3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.model.Centro;
import it.uniroma3.service.AttivitaService;
import it.uniroma3.service.CentroService;

@Controller
public class AziendaController {
	
	@Autowired
	private AttivitaService attivitaService;
	
	@Autowired
	private CentroService centroService;
	
	//gestioneAllievo
	@RequestMapping("/gestioneAzienda")
	public String gestioneAllievo(Model model) {
		return "gestioneAzienda";
	}
	
	//listaAttivitaCentro
	@RequestMapping(value = "/centro/{id}/attivita", method = RequestMethod.GET)
	public String attivitaCentro(@PathVariable("id") Long id, Model model) {
		model.addAttribute("centro", this.centroService.findById(id));
		Centro centro=this.centroService.findById(id);
		model.addAttribute("attivita", this.attivitaService.findByCentro(centro));
		return "attivitaCentroList";
	}
}
