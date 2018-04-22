package Database.Entities;

import java.util.ArrayList;
import java.util.List;

public class Question extends AbstractEntity{
    
    String questionString;
    String correctAnswer;
    List<String> answers = new ArrayList<>();
    
    public Question() {}
    
    public Question(Long id){
        this.id = id;
    }

    public String getQuestionString() {
        return questionString;
    }

    public void setQuestionString(String questionString) {
        this.questionString = questionString;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
    
     public void addAnswer(String answer) {
        answers.add(answer);
    }
   

    
    
    
    
}
