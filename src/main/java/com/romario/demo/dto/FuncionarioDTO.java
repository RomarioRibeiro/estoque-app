package com.romario.demo.dto;

import java.io.Serializable;

import com.romario.demo.domain.Funcionario;

public class FuncionarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String email;
	
	public FuncionarioDTO() {
		super();
	}
	
	public FuncionarioDTO (Funcionario obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	
	
	}

	public FuncionarioDTO(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
