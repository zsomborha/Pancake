package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Database.Controllers.QuestionController;

public class DataSource {
    
    private final String connectionUrl = "jdbc:derby://localhost:1527/Pancake";
    private final String userName = "root";
    private final String password = "root";
    
    private final QuestionController questionController;
    
    private DataSource(){
        this.questionController = new QuestionController();
    }
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(connectionUrl, userName, password);
    }
    
    public static DataSource getInstance(){
        return DataSourceHolder.INSTANCE;
    }
    
    private static class DataSourceHolder{
        private static final DataSource INSTANCE = new DataSource();
    }
    
    public long obtainNewId() throws SQLException {
        long id;
        try (final Connection connection = getConnection();
                final Statement stmt = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                        ResultSet.CONCUR_UPDATABLE);
                final ResultSet rs = stmt.executeQuery("SELECT VAL FROM IDSEQUENCE")) {
            rs.next();
            id = rs.getLong("VAL") + 1L;
            rs.updateLong("VAL", id);
            rs.updateRow();
        }
        return id;
    }    

    public QuestionController getQuestionController() {
        return questionController;
    }


    
}
