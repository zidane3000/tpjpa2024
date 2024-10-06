package jpa;


public class JpaTest {




	public JpaTest() {

	}
	
    public void createAndPersistEntities() {



/*
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

        SessionDao daoSession = new SessionDao();
        daoSession.delete(session);

            // Persist the Session


            // Create Kahoot
            Kahoot kahoot = new Kahoot();
            kahoot.setQuestion("What's your name 2?");
            kahoot.setClassement(1);
            kahoot.setSession(session); // Référence à la session persistée
            kahoot.setScore(10);
            kahoot.setType(Kahoot.Type.QUIZ);

            // Créer et ajouter des réponses possibles
            Collection<ReponsePossible> reponsesPossibles = new HashSet<>();
            ReponsePossible rep = new ReponsePossible("meryem2, zidane2");
            rep.setKahoot(kahoot); // Assure que la réponse connaît son kahoot
            reponsesPossibles.add(rep);
            kahoot.setReponsesPossibles(reponsesPossibles);

            // Persist the Kahoot
            KahootDao daoKahoot = new KahootDao();
            daoKahoot.delete(kahoot);

*/
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JpaTest test = new JpaTest();
		
		//EntityTransaction tx = manager.getTransaction();
		//tx.begin();
		try {
			
			// TODO create and persist com.kahoot.entity
			test.createAndPersistEntities();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//tx.commit();


		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

}
