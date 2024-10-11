package service;

import dao.implDao.ReponseParticipantDao;
import domain.ReponseParticipant;

public class ReponseParticipantService {

    private ReponseParticipantDao reponseParticipantDao = new ReponseParticipantDao();

    public ReponseParticipantService(){}

    public ReponseParticipantDao getReponseParticipantDao() {
        return this.reponseParticipantDao;
    }
}
