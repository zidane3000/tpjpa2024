package kahoot.dao.implDao;

import kahoot.domain.Utilisateur;
import kahoot.dao.AbstractJpaDao;

public class UtilisateurDao extends AbstractJpaDao<Long, Utilisateur> {

    public UtilisateurDao() {
        setClazz(Utilisateur.class);
    }
}
