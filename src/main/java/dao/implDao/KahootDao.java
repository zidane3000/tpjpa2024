package dao.implDao;

import dao.AbstractJpaDao;
import entity.Kahoot;

public class KahootDao extends AbstractJpaDao<Long, Kahoot> {

    public KahootDao() {
        super();
        setClazz(Kahoot.class);
    }
}
