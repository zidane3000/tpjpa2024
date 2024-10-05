package dao.implDao;

import dao.AbstractJpaDao;
import entity.Session;

public class SessionDao extends AbstractJpaDao<Long, Session> {

    public SessionDao() {
        setClazz(Session.class);
    }
}
