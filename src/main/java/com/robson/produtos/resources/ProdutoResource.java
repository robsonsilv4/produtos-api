package com.robson.produtos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robson.produtos.models.Produto;
import com.robson.produtos.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST de Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	@Autowired
	ProdutoRepository repo;

	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de Produtos")
	public List<Produto> listaProdutos() {
		return repo.findAll();
	}

	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna um Produto com base no id")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
		return repo.getById(id);
	}

	@PostMapping("/produto")
	@ApiOperation(value="Adiciona um novo Produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return repo.save(produto);
	}

	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta um Produto existente")
	public void deletaProduto(@RequestBody Produto produto) {
		repo.delete(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza as informações de um Produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return repo.save(produto);
	}

}
