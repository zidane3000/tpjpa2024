package kahoot.service;

import kahoot.dao.implDao.CreateurDao;

public class CreateurService {

    private CreateurDao createurDao = new CreateurDao();

    public CreateurService() {}
    public CreateurDao getCreateurDao() {return this.createurDao;}
}
