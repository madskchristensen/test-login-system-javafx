import java.sql.SQLException;

public class Authenticate {

    public boolean login (String username, String password) throws SQLException {
            return Jdbc.validateLogin(username, password);
    }
}