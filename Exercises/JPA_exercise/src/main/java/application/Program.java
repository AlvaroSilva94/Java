package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominion.Person;

public class Program {

	public static void main(String[] args) {
	
	// Create objects to be inserted into the table
	Person p1 = new Person(null, "Carlos da Silva","carlos@gmail.com");
	Person p2 = new Person(null, "Carlos Tony","cato@gmail.com");
	Person p3 = new Person(null, "José Fernando","zenando@gmail.com");
	
	//Entity manager is one of the main classes of JPA and is used to create
	//access to data; Entity manager factory is to create the entity manager
	
	//the field inside createEntityManagerFactory is the persistence-unit field in persistence.xml
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
	EntityManager em = emf.createEntityManager(); //Connection to db
	
	//to save in DB
	// Note: every operation that is not just a consultation
	// needs a transaction to take effect
	em.getTransaction().begin(); //to start operation with DB
	em.persist(p1);
	em.persist(p2);
	em.persist(p3);
	em.getTransaction().commit(); //to end operation with DB
	System.out.println("All done!");
	
	//To find by ID, convert data to object and instantiate object -> better than JDBC
	Person p = em.find(Person.class, 3);
	System.out.println(p);
	
	//To remove from DB
	// Note: Can only remove element that are monitored, which means that 
	// Can be removed only if its and element that was fetch from DB with find
	// or that was an element that was previously inserted in the DB
	em.remove(p);
	
	//To close both EntityManager and EntityManagerFactory
	em.close();
	emf.close();
	}

}
