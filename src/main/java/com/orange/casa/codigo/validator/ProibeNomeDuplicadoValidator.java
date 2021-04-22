package com.orange.casa.codigo.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.orange.casa.codigo.Aluno.Categoria;
import com.orange.casa.codigo.form.CategoriaForm;
import com.orange.casa.codigo.repository.CategoriaRepository;

@Component
public class ProibeNomeDuplicadoValidator implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CategoriaForm categoriaForm = (CategoriaForm) target;
		Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(categoriaForm.getNome());

		if (possivelCategoria.isPresent()) {
			errors.rejectValue("nome", null, "Já existe uma categoria com esse nome.");
		}
	}

}
