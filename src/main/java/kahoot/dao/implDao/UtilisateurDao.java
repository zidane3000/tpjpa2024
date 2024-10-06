package kahoot.dao.implDao;

import kahoot.domain.classAbstracts.Utilisateur;
import kahoot.dao.AbstractJpaDao;

public class UtilisateurDao extends AbstractJpaDao<Long, Utilisateur> {

    public UtilisateurDao() {
        setClazz(Utilisateur.class);
    }
}
