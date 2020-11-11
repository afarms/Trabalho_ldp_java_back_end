package com.atividade02.apihoroscopo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_MENSAGEM")
public class Mensagem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1836771914656671034L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String mensagem; 
	
	private long idplano;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public long getIdplano() {
		return idplano;
	}

	public void setIdplano(long idplano) {
		this.idplano = idplano;
	}
	
	
}
