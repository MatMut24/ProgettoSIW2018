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

import it.uniroma3.controller.validator.CentroValidator;
import it.uniroma3.model.Centro;
import it.uniroma3.service.CentroService;

@Controller
public class CentroController {

	@Autowired
	private CentroService centroService;
	
	@Autowired
	private CentroValidator validator;
	
	//Centri
	@RequestMapping("/centri")
	public String centri(Model model) {
		model.addAttribute("centri", centroService.findAll());
		return "centroList";
	}
	//getCentro
	@RequestMapping(value = "/centro/{id}", method = RequestMethod.GET)
    public String getCentro(@PathVariable("id") Long id, Model model) {
        model.addAttribute("centro", this.centroService.findById(id));
    	return "showCentro";
    }
	//addCentro
	@RequestMapping("/addCentro")
    public String addCentro(Model model) {
        model.addAttribute("centro", new Centro());
        return "centroForm";
    }
	//nuovoCentro
	@RequestMapping(value = "/centro", method = RequestMethod.POST)
    public String newCentro(@Valid @ModelAttribute("centro") Centro centro, 
    									Model model, BindingResult bindingResult) {
        this.validator.validate(centro, bindingResult);
        
        if (this.centroService.alreadyExists(centro)) {
            model.addAttribute("exists", "Centro already exists");
            return "centroForm";
        }
        else {
            if (!bindingResult.hasErrors()) {
                this.centroService.save(centro);
                model.addAttribute("centri", this.centroService.findAll());
                return "centriList";
            }
        }
        return "centroForm";
    }
}
