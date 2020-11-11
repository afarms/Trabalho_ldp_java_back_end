package com.atividade02.apihoroscopo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atividade02.apihoroscopo.models.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findById(long id);
	
	@Query("select c from Cliente c where  c.nome = ?1 and c.senha = ?2")
	Cliente findByNomeSenha(String nome, String senha);
}
