package com.romario.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.demo.domain.Categoria;



@Repository

public interface CategoriaRepository extends JpaRepository <Categoria , Integer>  {
	@Query(value="select*from categoria where id = ?",nativeQuery = true )
	Categoria find(Integer id);
}
