package kahoot.dao.implDao;

import kahoot.dao.AbstractJpaDao;
import kahoot.domain.Participant;

public class ParticipantDao extends AbstractJpaDao<Long, Participant> {
    public ParticipantDao() {this.setClazz(Participant.class);}
}
