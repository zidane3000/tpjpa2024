package service;

import domain.Session;

public class SessionDao extends AbstractJpaDao<Long, Session> {

    public SessionDao() {
        super();
        setClazz(Session.class);
    }
}
