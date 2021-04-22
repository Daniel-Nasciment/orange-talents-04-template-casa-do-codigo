package com.orange.casa.codigo.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.orange.casa.codigo.Aluno.Autor;
import com.orange.casa.codigo.form.AutorForm;
import com.orange.casa.codigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		
		AutorForm autorForm = (AutorForm) target;
		Optional<Autor> possivelAutor = autorRepository.findByEmail(autorForm.getEmail());
		
		
		if(possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Já existe um(a) outro(a) autor(a) com o mesmo e-mail.");
		}
	}

}
