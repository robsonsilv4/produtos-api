package com.robson.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robson.produtos.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public Produto getById(long id);
}
