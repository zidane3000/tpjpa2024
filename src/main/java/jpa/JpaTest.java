package jpa;

import dao.implDao.UtilisateurDao;
import domain.*;
import service.KahootService;
import service.ReponsePossibleService;
import service.UtilisateurService;

public class JpaTest {

	private UtilisateurService utilisateurService;
	private KahootService kahootService;
	private ReponsePossibleService reponsePossibleService;

	public JpaTest() {
		utilisateurService = new UtilisateurService();
		kahootService = new KahootService();
		reponsePossibleService = new ReponsePossibleService();
	}

    public void createAndPersistEntities() {

    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JpaTest test = new JpaTest();
		
		//EntityTransaction tx = manager.getTransaction();
		//tx.begin();
		try {
			
			// TODO create and persist entity
			test.createAndPersistEntities();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//tx.commit();


		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

}
