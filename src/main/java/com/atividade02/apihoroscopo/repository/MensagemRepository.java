package com.atividade02.apihoroscopo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atividade02.apihoroscopo.models.Mensagem;


public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
	Mensagem findById(long id);
	
	@Query( value="select m.* from tb_mensagem m, tb_cliente c,tb_plano p where c.id = ?1 and c.idplano = p.id and m.idplano <= p.id", nativeQuery = true)
	List<Mensagem> listarMensagens(long id);
}
