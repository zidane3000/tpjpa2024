package kahoot.service;

import kahoot.dao.implDao.KahootDao;

public class KahootService {

    private KahootDao kahootDao = new KahootDao();

    public KahootService() {}

    public KahootDao getKahootDao() {
        return this.kahootDao;
    }

}