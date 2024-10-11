package kahoot.service;


import kahoot.dao.implDao.QuestionDao;

public class QuestionService {

    private QuestionDao questionDao = new QuestionDao();

    public QuestionService() {}

    public QuestionDao getQuestionDao() {
        return this.questionDao;
    }
}