package com.orange.casa.codigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orange.casa.codigo.Aluno.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
