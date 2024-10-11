package kahoot.jpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JpaTest {


    private static EntityManager em;


	public JpaTest() {
        em = EntityManagerHelper.getEntityManager();
	}
	
    public void createAndPersistEntities() {



    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JpaTest test = new JpaTest();

		EntityTransaction tx = em.getTransaction();
        //tx.begin();
		try {

			// TODO create and persist rest.kahoot.entity
			test.createAndPersistEntities();

		} catch (Exception e) {

            e.printStackTrace(); // Affiche l'erreur pour le débogage
		}
        //tx.commit();


		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

}
