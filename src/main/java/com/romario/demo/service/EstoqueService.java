package com.romario.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romario.demo.domain.Estoque;
import com.romario.demo.domain.Funcionario;
import com.romario.demo.domain.Item_Estoque;
import com.romario.demo.repositry.EstoqueRepository;
import com.romario.demo.repositry.FuncionarioRepository;
import com.romario.demo.repositry.Item_EstoqueRepository;
import com.romario.demo.repositry.ProdutoRepository;
import com.romario.demo.service.exeption.DatalIntegrityException;
import com.romario.demo.service.exeption.ObjectNotFoundException;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository repo;

	@Autowired
	private ProdutoRepository repoproduto;

	@Autowired
	private Item_EstoqueRepository itens;

	@Autowired
	private EmailService emailService;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Estoque find(Integer id) {
		Optional<Estoque> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ",Tipo: " + Estoque.class.getName()));
	}

	public Estoque inserir(Estoque obj) {
		obj.setId(null);

		return repo.save(obj);
	}

	public Item_Estoque subtrair(Integer quanRetirado, int idproduto) {
		Item_Estoque itensestoqueproduto = itens.findProduto(idproduto);
		itensestoqueproduto.setQuantidade(itensestoqueproduto.getQuantidade() - quanRetirado);
		if (itensestoqueproduto.getQuantidade() <= 5) {
			List<Funcionario> funcionarios = funcionarioRepository.findAllCompras();
			for (Funcionario f : funcionarios) {
				emailService.sendEmail(f);
			}

		} else if(itensestoqueproduto.getQuantidade() < 0) {
			Optional<Item_Estoque> objt = Optional.empty();
			return objt.orElseThrow(() -> new ObjectNotFoundException("Estoque abaixo do limite"));
		}else {
			
		}
		return itens.save(itensestoqueproduto);
	

	}

	public Item_Estoque somar(Integer quansomar, int idproduto) {
		Item_Estoque itensestoqueproduto = itens.findProduto(idproduto);
		itensestoqueproduto.setQuantidade(itensestoqueproduto.getQuantidade() + quansomar);
		return itens.save(itensestoqueproduto);
	}

	public void delete(Integer id) {
		find(id);
		try {

			repo.deleteById(id);
		} catch (DatalIntegrityException e) {
			throw new DatalIntegrityException("Não e possivel excluir uma categoria que possui produtos");
		}

	}

}
