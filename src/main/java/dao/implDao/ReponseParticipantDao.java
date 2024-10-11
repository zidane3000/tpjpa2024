package dao.implDao;

import dao.AbstractJpaDao;
import domain.ReponseParticipant;

public class ReponseParticipantDao extends AbstractJpaDao<Long, ReponseParticipant>  {
    public ReponseParticipantDao() {setClazz(ReponseParticipant.class);}
}
