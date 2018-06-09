package it.uniroma3.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.model.Attivita;

@Component
public class CentroValidator implements Validator{

		@Override
	    public void validate(Object o, Errors errors) {
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required");
	    }

		@Override
		public boolean supports(Class<?> clazz) {
			return Attivita.class.equals(clazz);
		}

	}
