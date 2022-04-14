package com.romario.demo.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estoque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;	
	
	public Estoque() {
		super();
	}
	
	
	@OneToMany(mappedBy = "id.estoque")
	private Set<Item_Estoque> itens = new HashSet<>();
	
	
	public double getValor() {
		double soma = 0.0;
		for(Item_Estoque est : itens) {
			soma = soma - est.getsubTotal();
		}
		return soma;
	}
	
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Estoque(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;

		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}




	public Set<Item_Estoque> getItens() {
		return itens;
	}

	public void setItens(Set<Item_Estoque> itens) {
		this.itens = itens;
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
		Estoque other = (Estoque) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getDescricao());
		builder.append(getId());
		builder.append("Descrição: ");
	
		return builder.toString();
	}
	
	
	
	
}
