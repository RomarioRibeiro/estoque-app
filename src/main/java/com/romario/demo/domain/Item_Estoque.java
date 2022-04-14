package com.romario.demo.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item_Estoque implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemEstoquePK id = new ItemEstoquePK();

	private Integer quantidade;

	
	public Item_Estoque() {
		super();
	}

	public Item_Estoque(Estoque estoque, Produto produto, int quantidade) {
		super();
		id.setEstoque(estoque);
		id.setProduto(produto);
		this.quantidade = quantidade;
	}
	
	public double getsubTotal() {
		return (quantidade - quantidade);
	}

	@JsonIgnore
	public Estoque getEstoque() {
		return id.getEstoque();
	}

	public void setEstoque(Estoque estoque) {
		id.setEstoque(estoque);
	}

	public Produto getProduto() {

		return id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public ItemEstoquePK getId() {
		return id;
	}

	public void setId(ItemEstoquePK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
		Item_Estoque other = (Item_Estoque) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getProduto().getNome());
		builder.append("Produto: ");
		builder.append(getEstoque().getDescricao());
		builder.append(", :Descrição: ");
		builder.append(getId());
		return builder.toString();
	}

	
	
}
