package lanchonete.adapter.out.persistencia.jpa;

import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import lanchonete.aplicacao.dominio.cliente.CPF;
import lanchonete.aplicacao.dominio.cliente.Cliente;
import lanchonete.aplicacao.porta.out.persistencia.ClienteRepositorio;

public class ClienteRepositorioJpa implements ClienteRepositorio {

	private EntityManagerFactory entityManagerFactory;

	public ClienteRepositorioJpa(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	@Override
	public Optional<Cliente> buscar(CPF cpf) {
		try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
			Query query = entityManager.createNativeQuery("""
					SELECT *
					FROM cliente
					WHERE 1 = 1
					  AND cpf =:cpf
					""", ClienteJpaEntity.class)
					.setParameter("cpf", cpf.toString());
			try {
				ClienteJpaEntity result = (ClienteJpaEntity) query.getSingleResult();
				return ClienteMapper.toModelEntityOptional(result);
			} catch (Exception e) {
				return Optional.empty();
			}
		}
	}

	@Override
	public void salvar(Cliente cliente) {
		try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
			entityManager.getTransaction().begin();
			entityManager.merge(ClienteMapper.toJpaEntity(cliente));
			entityManager.getTransaction().commit();
		}
	}

}
