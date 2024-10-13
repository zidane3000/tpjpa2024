package kahoot.dao.implDao;

import kahoot.dao.AbstractJpaDao;
import kahoot.domain.Createur;

public class CreateurDao extends AbstractJpaDao<Long, Createur> {
    public CreateurDao() {
        this.setClazz(Createur.class);
    }
}
