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
        entity.setQuestionString(resultSet.getString(2));
        entity.setCorrectAnswer(resultSet.getString(3));
        entity.addAnswer(resultSet.getString(4));
        entity.addAnswer(resultSet.getString(5));
        entity.addAnswer(resultSet.getString(6));
    }

    @Override
    protected void getEntityAttributes(ResultSet resultSet, Question entity) throws SQLException {
        resultSet.updateString("QUESTION_STRING", entity.getQuestionString());
        resultSet.updateString("CORRECT_ANSWER", entity.getCorrectAnswer());
    }
    
}
