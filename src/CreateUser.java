import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class CreateUser {

    public Button buttonCreateUser;
    public Button buttonBack;
    public TextField username;
    public TextField email;
    public PasswordField password;
    Login login = new Login();

    public void showScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateUser.fxml"));
        Main.window.setTitle("Create User");
        Main.window.setScene(new Scene(root, 300, 275));
    }

    public void handleCreateUser() {
        try {
            String username = this.username.getText();
            String password = this.password.getText();
            String email = this.email.getText();

            Jdbc.createUser(username, password, email);
            login.showScene();

        } catch(SQLException | IOException e){
            e.printStackTrace();
        }
    }

    public void handleBack() throws IOException {
        login.showScene();
    }
}
