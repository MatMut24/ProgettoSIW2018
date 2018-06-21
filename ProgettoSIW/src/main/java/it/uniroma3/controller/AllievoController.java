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

import it.uniroma3.controller.validator.AllievoValidator;
import it.uniroma3.model.Allievo;
import it.uniroma3.service.AllievoService;

@Controller
public class AllievoController {

	@Autowired
	private AllievoService allievoService;
	
	@Autowired
	private AllievoValidator validator;
	
	//gestioneAllievo
	@RequestMapping("/gestioneAllievo")
	public String gestioneAllievo(Model model) {
		return "gestioneAllievo";
	}
	
	//addAllievo
	@RequestMapping("/addAllievo")
    public String addAllievo(Model model) {
        model.addAttribute("allievo", new Allievo());
        return "allievoForm";
    }
	@RequestMapping("/allievi")
    public String showAllievi(Model model) {
		 model.addAttribute("allievi", this.allievoService.findAll());
         return "allievoList";
    }
	//nuovoAllievo
	@RequestMapping(value = "/allievo", method = RequestMethod.POST)
    public String newAllievo(@Valid @ModelAttribute("allievo") Allievo allievo, 
    									BindingResult bindingResult, Model model) {
        this.validator.validate(allievo, bindingResult);
        
        if (this.allievoService.alreadyExists(allievo)) {
            model.addAttribute("exists", "Allievo already exists");
            return "allievoForm";
        }
        else {
            if (!bindingResult.hasErrors()) {
                this.allievoService.save(allievo);
                model.addAttribute("allievi", this.allievoService.findAll());
                return "allievoList";
            }
        }
        return "allievoForm";
    }
	
}
