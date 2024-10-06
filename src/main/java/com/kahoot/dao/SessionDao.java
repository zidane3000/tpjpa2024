package com.kahoot.dao;

import com.kahoot.entity.Session;

public class SessionDao extends AbstractJpaDao<Long, Session> {

    public SessionDao() {
        super();
        setClazz(Session.class);
    }
}
