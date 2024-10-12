package kahoot.dao.implDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import kahoot.dao.AbstractJpaDao;
import kahoot.domain.Kahoot;
import kahoot.dto.KahootDTO;
import org.jboss.resteasy.annotations.Query;

import static kahoot.jpa.EntityManagerHelper.getEntityManager;


public class KahootDao extends AbstractJpaDao<Long, Kahoot> {

    public KahootDao() {
        this.setClazz(Kahoot.class);
    }


    public Kahoot getKahootById(long id){
        EntityManager em = getEntityManager(); // Assurez-vous que vous avez une méthode pour obtenir l'EntityManager
        try {
            TypedQuery<Kahoot> query = em.createQuery("SELECT k FROM Kahoot k WHERE k.id = :id", Kahoot.class);
            query.setParameter("id", id);
            return query.getSingleResult(); // Récupère le résultat unique
        } catch (NoResultException e) {
            // Gérer le cas où aucun résultat n'est trouvé
            return null; // ou lancer une exception personnalisée
        } catch (Exception e) {
            // Gérer les autres exceptions
            e.printStackTrace();
            return null; // ou relancer l'exception
        }
    }
}
