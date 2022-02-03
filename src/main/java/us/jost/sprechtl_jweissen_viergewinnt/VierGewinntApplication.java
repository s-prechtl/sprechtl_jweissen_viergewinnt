package us.jost.sprechtl_jweissen_viergewinnt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import us.jost.sprechtl_jweissen_viergewinnt.controller.ControllerColorPickerGUI;
import us.jost.sprechtl_jweissen_viergewinnt.controller.ControllerNamePickerGUI;

import java.io.IOException;

public class VierGewinntApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VierGewinntApplication.class.getResource("vierGewinnt-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("VIER GEWINNT!");
        stage.setScene(scene);
        stage.show();
        ControllerColorPickerGUI.display();
        ControllerNamePickerGUI.display();
    }

    public static void main(String[] args) {
        launch();
    }
}