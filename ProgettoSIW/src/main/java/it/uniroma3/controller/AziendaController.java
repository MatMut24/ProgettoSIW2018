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
import it.uniroma3.model.Attivita;
import it.uniroma3.model.Centro;
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
}
