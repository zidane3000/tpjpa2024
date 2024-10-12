package kahoot.dao.implDao;

import kahoot.dao.AbstractJpaDao;

import kahoot.domain.Question;

public class QuestionDao extends AbstractJpaDao<Long, Question> {

    public QuestionDao() {setClazz(Question.class);}
}