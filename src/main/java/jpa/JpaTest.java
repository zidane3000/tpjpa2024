package jpa;


import entity.Createur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JpaTest {


	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			EntityManager manager = EntityManagerHelper.getEntityManager();
			System.out.println(".. start");
		JpaTest test = new JpaTest(manager);
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
		
			// TODO create and persist entity
			Createur createur = new Createur();
			manager.persist(createur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

			
   	 manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}




}
