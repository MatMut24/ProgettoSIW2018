package it.uniroma3.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import it.uniroma3.controller.validator.AttivitaValidator;

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
	private AttivitaValidator validator;
	
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
	
	@RequestMapping(value = "/centro/{id}/newAttivita", method = RequestMethod.GET)
	public String addAttivitaCentro(@PathVariable("id") Long id, Model model) {
		model.addAttribute("centro", this.centroService.findById(id));
		model.addAttribute("attivita", new Attivita());
		return "attivitaForm";
	}
	
	@RequestMapping(value = "/centro/{id}/attivitaCentro", method = RequestMethod.POST)
	public String newAttivita(@Valid @ModelAttribute("attivita") Attivita attivita, @PathVariable("id") Long id,
			Model model, BindingResult bindingResult) {
		model.addAttribute("centro", this.centroService.findById(id));
		this.validator.validate(attivita, bindingResult);
		attivita.setCentro(this.centroService.findById(id));
		if (this.attivitaService.alreadyExists(attivita)) {
			model.addAttribute("exists", "Attivita already exists");
			return "attivitaForm";
		}
		else {
			if (!bindingResult.hasErrors()) {
				this.attivitaService.save(attivita);
				model.addAttribute("attivita", this.attivitaService.findAll());
				return "attivitaCentroList";
			}
		}
		return "attivitaForm";
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
		
	//addAllievoAttivita
	@RequestMapping("/addAllievoAttivita")
	public String addAllievoAttivita(Model model) {
		model.addAttribute("centri", centroService.findAll());
		return "centroAttivita";
	}
	
	@RequestMapping(value = "/scegliCentro/{id}")
	public String ScegliCentroPartecipazione(@PathVariable("id") Long id, Model model) {
		model.addAttribute("centro", centroService.findById(id));
		Centro centro = centroService.findById(id);
		model.addAttribute("attivita", centro.getAttivita());
		return "scegliAttivita";
	}
	
	@RequestMapping(value = "**/attivita/{id}/scegliAllievo", method = RequestMethod.GET)
	public String getAllieviCentro(@PathVariable("id") Long id, Model model) {	
		Attivita attivita = this.attivitaService.findById(id);
		Centro centro = attivita.getCentro();
		model.addAttribute("centro", centro);
		model.addAttribute("attivita", attivita);
		model.addAttribute("allievi", allievoService.findAll());
		return "partecipantiAttivitaCentroList";
	}
	
	@RequestMapping(value = "/attivita/{id1}/scegliAllievo/{id2}", method = RequestMethod.GET)
	public String partecipazione(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2, Model model) {
		Attivita attivita = this.attivitaService.findById(id1);
		model.addAttribute("attivita", attivita);
		Allievo allievo = allievoService.findById(id2);		
		
		if (attivita.getAllievi().contains(allievo)) {
			model.addAttribute("exists", "Allievo gia iscritto");
			return "partecipantiAttivitaCentroList";
		}
		else {
			attivita.getAllievi().add(allievo);
			allievo.getAttivita().add(attivita);
			model.addAttribute("attivita", attivita);
			model.addAttribute("allievi", attivita.getAllievi());
			return "showAttivitaCentro";
		}
	}
}
