package com.romario.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.demo.domain.Item_Estoque;



@Repository

public interface Item_EstoqueRepository extends JpaRepository <Item_Estoque , Integer>  {
	@Query(value="select * from item_estoque where id = ?",nativeQuery = true )
	Item_Estoque find(Integer id);
	@Query(value="select * from item_estoque where produto_id = ?",nativeQuery = true )
	Item_Estoque findProduto(int idproduto);
}
