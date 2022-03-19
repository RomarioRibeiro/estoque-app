package com.romario.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.demo.domain.Produto;



@Repository

public interface ProdutoRepository extends JpaRepository <Produto , Integer>  {
	@Query(value="select * from produto where id = ?",nativeQuery = true )
	Produto find(Integer id);
}
