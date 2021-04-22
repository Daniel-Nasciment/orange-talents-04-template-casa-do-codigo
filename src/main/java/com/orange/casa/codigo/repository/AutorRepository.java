package com.orange.casa.codigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orange.casa.codigo.Aluno.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);

}
