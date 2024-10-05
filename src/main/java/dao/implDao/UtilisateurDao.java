package dao.implDao;

import classAbstracts.Utilisateur;
import dao.AbstractJpaDao;

public class UtilisateurDao extends AbstractJpaDao<Long, Utilisateur> {

    public UtilisateurDao() {
        setClazz(Utilisateur.class);
    }
}
