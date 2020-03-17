import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class Login {
    public Button buttonLogin;
    public Label label;
    public TextField username;
    public PasswordField password;
    public Button buttonCreateUser;
    private Authenticate auth = new Authenticate();

    public void showScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Main.window.setTitle("Login");
        Main.window.setScene(new Scene(root, 300, 275));
    }

    public void handleLogInAction() throws IOException, SQLException {
        boolean logInResult = auth.login(username.getText(), password.getText());
        Member member = new Member();

        if (logInResult) {
            member.showScene();
        } else {
            System.out.println("Ikke OK");
        }
    }

    public void handleCreateUser() throws IOException {
        CreateUser createUser = new CreateUser();

        createUser.showScene();
    }

    public void testMysql() throws SQLException {
        Jdbc.connect();
    }
}