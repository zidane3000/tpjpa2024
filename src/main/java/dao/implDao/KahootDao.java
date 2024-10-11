package dao.implDao;

import dao.AbstractJpaDao;
import domain.Kahoot;

public class KahootDao extends AbstractJpaDao<Long, Kahoot> {

    public KahootDao() {
        setClazz(Kahoot.class);
    }
}
