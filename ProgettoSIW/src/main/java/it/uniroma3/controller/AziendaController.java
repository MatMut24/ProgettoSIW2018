package it.uniroma3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.model.Allievo;
import it.uniroma3.model.Attivita;
import it.uniroma3.model.Centro;
import it.uniroma3.service.AllievoService;
import it.uniroma3.service.AttivitaService;
import it.uniroma3.service.CentroService;

@Controller
public class AziendaController {

	@Autowired
	private AttivitaService attivitaService;

	@Autowired
	private CentroService centroService;

	@Autowired
	private AllievoService allievoService;

	//gestioneAllievo
	@RequestMapping("/gestioneAzienda")
	public String gestioneAllievo(Model model) {
		return "gestioneAzienda";
	}

	//listaAttivitaCentro
	@RequestMapping(value = "/centro/{id}/attivita", method = RequestMethod.GET)
	public String attivitaCentro(@PathVariable("id") Long id, Model model) {
		model.addAttribute("centro", this.centroService.findById(id));
		Centro centro = this.centroService.findById(id);
		model.addAttribute("attivita", this.attivitaService.findByCentro(centro));
		return "attivitaCentroList";
	}

	//showAttivita
	@RequestMapping(value = "**/attivita/{id}", method = RequestMethod.GET)
	public String getAttivitaCentro(@PathVariable("id") Long id, Model model) {	
		Attivita attivita = this.attivitaService.findById(id);
		model.addAttribute("attivita", attivita);
		model.addAttribute("allievi", attivita.getAllievi());
		return "showAttivitaCentro";
	}

	//PartecipantiAttivitaCentroList
	@RequestMapping(value = "**/{id}/allievi", method = RequestMethod.GET)
	public String getPartecipantiAttivitaCentro(@PathVariable("id") Long id, Model model) {	
		Attivita attivita = this.attivitaService.findById(id);
		model.addAttribute("allievi", attivita.getAllievi());
		return "partecipantiAttivitaCentroList";
	}

	//listaAttivitaAllievo
	@RequestMapping(value = "/allievo/{id}/attivita", method = RequestMethod.GET)
	public String attivitaAllievo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("allievo", this.centroService.findById(id));
		Allievo allievo = this.allievoService.findById(id);
		model.addAttribute("attivita", allievo.getAttivita());
		return "attivitaAllievoList";
	}

	//Allievi
	@RequestMapping("/allieviAzienda")
	public String allievi(Model model) {
		model.addAttribute("allievi", allievoService.findAll());
		return "allievoAziendaList";
	}
	
	//getAllievo
		@RequestMapping(value = "/allievoAzienda/{id}", method = RequestMethod.GET)
	    public String getAllievo(@PathVariable("id") Long id, Model model) {
	        model.addAttribute("allievo", this.allievoService.findById(id));
	    	return "showAttivitaAllievo";
	    }
}
