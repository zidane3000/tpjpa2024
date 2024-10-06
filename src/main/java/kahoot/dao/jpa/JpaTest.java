package kahoot.dao.jpa;


import java.util.*;

import kahoot.dao.implDao.KahootDao;
import kahoot.dao.implDao.SessionDao;
import kahoot.dao.implDao.UtilisateurDao;
import kahoot.domain.Createur;
import kahoot.domain.Kahoot;
import kahoot.domain.ReponsePossible;
import kahoot.domain.Session;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JpaTest {


    private static EntityManager em;


	public JpaTest() {
        em = EntityManagerHelper.getEntityManager();
	}
	
    public void createAndPersistEntities() {

        // Create a Createur
        Createur createur = new Createur();
        createur.setNom("nicolas2");
        createur.setPrenom("Doe2");
        createur.setProfession("Teacher");

        // Persist the Createur
        UtilisateurDao daoUtilisateur = new UtilisateurDao();
        daoUtilisateur.save(createur);

        // Create a Session
        Session session = new Session();
        session.setPIN(1234567);
        session.setScore_final(100);
        session.setCreateur(createur);

        // Persist the Session
        SessionDao daoSession = new SessionDao();
        daoSession.save(session); // Utilise save au lieu de delete

        // Create Kahoot
        Kahoot kahoot = new Kahoot();
        kahoot.setQuestion("What's your age?");
        kahoot.setClassement(1);
        kahoot.setSession(session);
        kahoot.setScore(10);
        kahoot.setType(Kahoot.Type.QUIZ);

        // Créer et ajouter des réponses possibles
        Collection<ReponsePossible> reponsesPossibles = new HashSet<>();
        ReponsePossible rep = new ReponsePossible("20, 25");
        rep.setKahoot(kahoot);
        reponsesPossibles.add(rep);
        kahoot.setReponsesPossibles(reponsesPossibles);

        // Persist the Kahoot
        KahootDao daoKahoot = new KahootDao();
        daoKahoot.save(kahoot); // Utilise save au lieu de delete


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
