package com.kahoot.dao;

import com.kahoot.entity.classAbstracts.Utilisateur;

public class UtilisateurDao extends AbstractJpaDao<Long, Utilisateur> {

    public UtilisateurDao() {
        super();
        setClazz(Utilisateur.class);
    }
}
