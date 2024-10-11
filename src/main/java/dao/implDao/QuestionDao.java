package dao.implDao;

import dao.AbstractJpaDao;
import domain.Question;

public class QuestionDao extends AbstractJpaDao<Long, Question> {

    public QuestionDao() {setClazz(Question.class);}
}
