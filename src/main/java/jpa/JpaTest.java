package jpa;


import java.util.Date;

import entity.Createur;
import entity.Participant;
import entity.ReponseParticipant;
import entity.ReponsePossible;
import entity.Session;

import java.util.ArrayList;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JpaTest {


	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	
    public void createAndPersistEntities() {
        // Create a Createur
        Createur createur = new Createur();
        createur.setNom("John");
        createur.setPrenom("Doe");
        createur.setProfession("Teacher");

        // Persist the Createur
        manager.persist(createur);

        // Create a Session
        Session session = new Session();
        session.setPIN(123456);
        session.setScore_final(100);
        session.setCreateur(createur);

        // Persist the Session
        manager.persist(session);

        // Create a Participant
        Participant participant = new Participant();
        participant.setNom("Jane");
        participant.setPrenom("Smith");
        participant.setProfession("Student");
        participant.setSession(session);

        // Persist the Participant
        manager.persist(participant);

        // Create a ReponsePossible
        ReponsePossible reponsePossible = new ReponsePossible();
        reponsePossible.setReponses("Answer 1, Answer 2, Answer 3");

        // Persist the ReponsePossible
        manager.persist(reponsePossible);

        // Create a ReponseParticipant
        ReponseParticipant reponseParticipant = new ReponseParticipant();
        reponseParticipant.setText("Answer 1");
        reponseParticipant.setCorrect(true);
        reponseParticipant.setReponsePossible(reponsePossible);
        reponseParticipant.setParticipant(participant);
        reponseParticipant.setSession(session);
        reponseParticipant.setDate(new Date());

        // Persist the ReponseParticipant
        manager.persist(reponseParticipant);

        // Add the entities to their respective collections
        session.setParticipants(new ArrayList<>());
        session.getParticipants().add(participant);

        session.setReponsesParticipants(null);
        session.getReponsesParticipants().add(reponseParticipant);

        createur.setSessions(new ArrayList<>());
        createur.getSessions().add(session);

        participant.setReponseParticipant(new ArrayList<>());
        participant.getReponseParticipant().add(reponseParticipant);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			
			// TODO create and persist entity
			test.createAndPersistEntities();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

			
   	 manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

}
