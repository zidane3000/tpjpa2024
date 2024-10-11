package kahoot.dao.implDao;


import kahoot.dao.AbstractJpaDao;
import kahoot.domain.ReponsePossible;

public class ReponsePossibleDao extends AbstractJpaDao<Long, ReponsePossible> {

    public ReponsePossibleDao() {
        setClazz(ReponsePossible.class);
    }
}