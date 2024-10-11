package kahoot.service;


import kahoot.dao.implDao.ReponseParticipantDao;

public class ReponseParticipantService {

    private ReponseParticipantDao reponseParticipantDao = new ReponseParticipantDao();

    public ReponseParticipantService(){}

    public ReponseParticipantDao getReponseParticipantDao() {
        return this.reponseParticipantDao;
    }
}