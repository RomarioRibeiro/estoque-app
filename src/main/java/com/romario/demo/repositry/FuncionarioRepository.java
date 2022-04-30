package com.romario.demo.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.romario.demo.domain.Funcionario;



@Repository

public interface FuncionarioRepository extends JpaRepository <Funcionario , Integer>  {
	@Query(value="select * from funcionario where id = ?",nativeQuery = true )
	Funcionario find(Integer id);
	
	@Transactional(readOnly = true)
	Funcionario findByEmail (String email);
	@Query(value="select * from funcionario where perfil = \"Compra\"",nativeQuery = true )
	List<Funcionario> findAllCompras();

}
