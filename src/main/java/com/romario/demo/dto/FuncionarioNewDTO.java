package com.romario.demo.dto;

import java.io.Serializable;
import java.util.Date;

import com.romario.demo.service.validation.FuncionarioInserte;

@FuncionarioInserte
public class FuncionarioNewDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	private String nome;
	private  String cpf;
	private String email;
	private String perfil;
	private Date dataDeNasc;
	
	public FuncionarioNewDTO() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataDeNasc() {
		return dataDeNasc;
	}

	public void setDataDeNasc(Date dataDeNasc) {
		this.dataDeNasc = dataDeNasc;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
	
}
