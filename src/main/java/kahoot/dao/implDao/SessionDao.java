package kahoot.dao.implDao;

import kahoot.dao.AbstractJpaDao;
import kahoot.domain.Session;

public class SessionDao extends AbstractJpaDao<Long, Session> {

    public SessionDao() {
        setClazz(Session.class);
    }
}
