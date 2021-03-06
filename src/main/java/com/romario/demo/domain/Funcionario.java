package com.romario.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Funcionario  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String perfil;
	private  String cpf;
	private String email;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataDeNasc;
	
	
	
	
	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Funcionario() {
		super();
	}

	public Funcionario(Integer id, String nome, String cpf, String email, Date dataDeNasc, String perfil) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataDeNasc = dataDeNasc;
		this.perfil = perfil;
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

	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario: ");
		builder.append(getId());
		builder.append(", Nome: ");
		builder.append(getNome());
		builder.append(", CPF: ");
		builder.append(getCpf());
		builder.append(", email: ");
		builder.append(getEmail());
		builder.append(", Data De Nacimento: ");
		builder.append(getDataDeNasc());
		return builder.toString();
	}

	
	
	
	
}
