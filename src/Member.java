import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class Member {
    public Button buttonBack;
    Login login = new Login();

    public void showScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Member.fxml"));
        Main.window.setTitle("Members Page");
        Main.window.setScene(new Scene(root, 300, 275));
    }

    public void handleButtonBack() throws IOException {
        login.showScene();
    }
}
