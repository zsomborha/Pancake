package DatabaseTest;

import Database.DataSource;
import Database.Entities.Question;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseTest {
    
    public static void main(String[] args) {
        
        try {
            List<Question> list = DataSource.getInstance().getQuestionController().getEntities();
            for(Question entity: list) {
                System.out.println(entity.getQuestionString());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
       }
    }
    
}
