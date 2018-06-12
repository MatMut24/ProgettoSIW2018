package it.uniroma3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AziendaController {
	
	
	//gestioneAllievo
	@RequestMapping("/gestioneAzienda")
	public String gestioneAllievo(Model model) {
		return "gestioneAzienda";
	}
}
