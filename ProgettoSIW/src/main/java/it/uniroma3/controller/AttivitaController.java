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

import it.uniroma3.service.AttivitaService;
import it.uniroma3.controller.validator.AttivitaValidator;
import it.uniroma3.model.Attivita;
import it.uniroma3.model.Centro;

@Controller
public class AttivitaController {

	@Autowired
	private AttivitaService attivitaService;

	@Autowired
	private AttivitaValidator validator;

	//Attivita
	@RequestMapping("/attivita")
	public String attivita(Model model) {
		model.addAttribute("attivita", attivitaService.findAll());
		return "attivitaList";
	}

	//addAttivita
	@RequestMapping("/addAttivita")
	public String addAttivita(Model model) {
		model.addAttribute("attivita", new Attivita());
		return "attivitaForm";
	}
	
	//getAttivita
	@RequestMapping(value = "/attivita/{id}", method = RequestMethod.GET)
	public String getAttivita(@PathVariable("id") Long id, Model model) {
		model.addAttribute("attivita",this.attivitaService.findById(id));
		return "showAttivita";
	}

	//nuovaAttivita
	@RequestMapping(value = "/attivita", method = RequestMethod.POST)
	public String newAttivita(@Valid @ModelAttribute("attivita") Attivita attivita, 
			Model model, BindingResult bindingResult) {
		this.validator.validate(attivita, bindingResult);

		if (this.attivitaService.alreadyExists(attivita)) {
			model.addAttribute("exists", "Attivita already exists");
			return "attivitaForm";
		}
		else {
			if (!bindingResult.hasErrors()) {
				this.attivitaService.save(attivita);
				model.addAttribute("attivita", this.attivitaService.findAll());
				return "attivitaList";
			}
		}
		return "attivitaForm";
	}
}
