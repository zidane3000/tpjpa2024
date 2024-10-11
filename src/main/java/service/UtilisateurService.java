package service;

import dao.implDao.UtilisateurDao;

public class UtilisateurService {

    private UtilisateurDao utilisateurDao = new UtilisateurDao();

    public UtilisateurService() {}

    public UtilisateurDao getUtilisateurDao() {
        return utilisateurDao;
    }
}
