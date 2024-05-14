package lanchonete.adapter.out.persistencia.jpa;

import java.util.List;
import java.util.Optional;

import lanchonete.aplicacao.dominio.produto.Produto;

class ProdutoMapper {
	private ProdutoMapper() {}

	static ProdutoJpaEntity toJpaEntity(Produto produto) {
		ProdutoJpaEntity jpaEntity = new ProdutoJpaEntity(produto.getId(), produto.getNome(), produto.getTipo(), produto.getValor());
		return jpaEntity;
	}

	static Optional<Produto> toModelEntityOptional(ProdutoJpaEntity jpaEntity) {
		return Optional.ofNullable(jpaEntity).map(ProdutoMapper::toModelEntity);
	}

	static Produto toModelEntity(ProdutoJpaEntity jpaEntity) {
		return new Produto(
				jpaEntity.getId(), 
				jpaEntity.getNome(),
				jpaEntity.getTipo(), 
				jpaEntity.getPrecoUnitario());
	}

	static List<Produto> toModelEntities(List<ProdutoJpaEntity> jpaEntities) {
		return jpaEntities.stream().map(ProdutoMapper::toModelEntity).toList();
	}
}
