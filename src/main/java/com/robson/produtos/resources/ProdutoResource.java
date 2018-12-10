package com.robson.produtos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robson.produtos.models.Produto;
import com.robson.produtos.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {
	@Autowired
	ProdutoRepository repo;

	@GetMapping("/produtos")
	public List<Produto> listaProdutos() {
		return repo.findAll();
	}

	@GetMapping("/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
		return repo.getById(id);
	}

	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return repo.save(produto);
	}

}
