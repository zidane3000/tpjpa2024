package service;

import domain.classAbstracts.Utilisateur;

public class UtilisateurDao extends AbstractJpaDao<Long, Utilisateur> {

    public UtilisateurDao() {
        super();
        setClazz(Utilisateur.class);
    }
}
