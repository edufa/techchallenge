package lanchonete.adapter.out.persistencia.jpa;

import java.util.Map;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class EntityManagerFactoryFactory {

	private EntityManagerFactoryFactory() {
	}

	public static EntityManagerFactory createMySqlEntityManagerFactory(String jdbcUrl, String user, String password) {
		return Persistence.createEntityManagerFactory("lanchonete.adaptador.out.persistence.jpa",
				Map.of(
						"hibernate.dialect", "org.hibernate.dialect.MySQLDialect", 
						"hibernate.hbm2ddl.auto", "update",
						"jakarta.persistence.jdbc.driver", "com.mysql.jdbc.Driver", 
						"jakarta.persistence.jdbc.url", jdbcUrl, 
						"jakarta.persistence.jdbc.user", user, 
						"jakarta.persistence.jdbc.password", password));
	}
}