package service;

import dao.implDao.ReponsePossibleDao;

public class ReponsePossibleService {

    private ReponsePossibleDao reponsePossibleDao = new ReponsePossibleDao();

    public ReponsePossibleService() {}

    public ReponsePossibleDao getReponsePossibleDao() {
        return reponsePossibleDao;
    }
}
