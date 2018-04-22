package Database.Controllers;

import Database.Entities.Question;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionController extends AbstractController<Question>{
    
    public QuestionController() {
        super("QUESTION");
    }

    @Override
    protected Question newEntity() {
        return new Question();
    }

    @Override
    protected void setEntityAttributes(Question entity, ResultSet resultSet) throws SQLException {
        entity.setQuestionString(resultSet.getString(1));
        entity.setCorrectAnswer(resultSet.getString(2));
    }

    @Override
    protected void getEntityAttributes(ResultSet resultSet, Question entity) throws SQLException {
        resultSet.updateString("QUESTION_STRING", entity.getQuestionString());
        resultSet.updateString("CORRECT_ANSWER", entity.getCorrectAnswer());
    }
    
}
