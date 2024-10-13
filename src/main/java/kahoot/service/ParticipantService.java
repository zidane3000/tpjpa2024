package kahoot.service;

import kahoot.dao.implDao.ParticipantDao;

public class ParticipantService {
    private ParticipantDao participantDao = new ParticipantDao();

    public ParticipantService() {}

    public ParticipantDao getParticipantDao() {return this.participantDao;}
}
