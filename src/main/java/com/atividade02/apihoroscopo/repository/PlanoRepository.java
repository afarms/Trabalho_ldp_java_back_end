package com.atividade02.apihoroscopo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atividade02.apihoroscopo.models.Plano;


public interface PlanoRepository extends JpaRepository<Plano, Long> {
	
	Plano findById(long id);
	
	@Query("select p from Plano p where  p.nome = ?1")
	Plano teste(long id);
}
