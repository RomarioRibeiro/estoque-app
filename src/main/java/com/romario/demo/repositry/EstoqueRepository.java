package com.romario.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.demo.domain.Estoque;



@Repository

public interface EstoqueRepository extends JpaRepository <Estoque , Integer>  {
	@Query(value="select * from estoque where id = ?",nativeQuery = true )
	Estoque find(Integer id);
}
