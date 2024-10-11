package kahoot.dao.implDao;


import kahoot.dao.AbstractJpaDao;
import kahoot.domain.ReponseParticipant;

public class ReponseParticipantDao extends AbstractJpaDao<Long, ReponseParticipant> {
    public ReponseParticipantDao() {setClazz(ReponseParticipant.class);}
}