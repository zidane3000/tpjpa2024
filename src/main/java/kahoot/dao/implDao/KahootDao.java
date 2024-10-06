package kahoot.dao.implDao;

import kahoot.dao.AbstractJpaDao;
import kahoot.domain.Kahoot;

public class KahootDao extends AbstractJpaDao<Long, Kahoot> {

    public KahootDao() {
        this.setClazz(Kahoot.class);
    }
}
