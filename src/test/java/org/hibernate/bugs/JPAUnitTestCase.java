package org.hibernate.bugs;

import org.hibernate.model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.assertNotNull;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void findByDomainIdFieldTest() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Customer customer = new Customer(1, "Francisco");
		entityManager.persist(customer);

		Customer foundCustomer = entityManager.createQuery(
				"from Customer c where c.id.someDomainField = :someDomainField",
						Customer.class)
				.setParameter("someDomainField", customer.getId().getSomeDomainField())
				.getSingleResult();

		assertNotNull(foundCustomer);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
