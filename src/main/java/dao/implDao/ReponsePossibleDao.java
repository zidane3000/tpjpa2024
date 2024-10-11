package dao.implDao;

import dao.AbstractJpaDao;
import domain.ReponsePossible;

public class ReponsePossibleDao extends AbstractJpaDao<Long, ReponsePossible> {

    public ReponsePossibleDao() {
        setClazz(ReponsePossible.class);
    }
}
