package lanchonete.adapter.out.persistencia.jpa;

import java.util.List;
import java.util.Optional;

import lanchonete.aplicacao.dominio.cliente.Cliente;

class ClienteMapper {
	private ClienteMapper() {}

	static ClienteJpaEntity toJpaEntity(Cliente cliente) {
		ClienteJpaEntity jpaEntity = new ClienteJpaEntity(cliente.getCpf(), cliente.getNome(), cliente.getEmail());

//		jpaEntity.setId(product.id().value());
//		jpaEntity.setName(product.name());
//		jpaEntity.setDescription(product.description());
//		jpaEntity.setPriceCurrency(product.price().currency().getCurrencyCode());
//		jpaEntity.setPriceAmount(product.price().amount());
//		jpaEntity.setItemsInStock(product.itemsInStock());

		return jpaEntity;
	}

	static Optional<Cliente> toModelEntityOptional(ClienteJpaEntity jpaEntity) {
		return Optional.ofNullable(jpaEntity).map(ClienteMapper::toModelEntity);
	}

	static Cliente toModelEntity(ClienteJpaEntity jpaEntity) {
		return new Cliente(
				jpaEntity.getId(), 
				jpaEntity.getCpf(),
				jpaEntity.getNome(), 
				jpaEntity.getEmail());
	}

	static List<Cliente> toModelEntities(List<ClienteJpaEntity> jpaEntities) {
		return jpaEntities.stream().map(ClienteMapper::toModelEntity).toList();
	}
}
