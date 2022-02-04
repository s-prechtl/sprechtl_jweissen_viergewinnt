package us.jost.sprechtl_jweissen_viergewinnt.controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.stage.Stage;
import us.jost.sprechtl_jweissen_viergewinnt.VierGewinntApplication;

import java.io.IOException;

public class ControllerColorPickerGUI {

    public ColorPicker ColorPickerPlayerColor;

    public static Stage getStage() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VierGewinntApplication.class.getResource("colorPicker-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("COLOR!");
        stage.setScene(scene);

        return stage;
    }

    public void onConfirmButtonPressed() {
        ((Stage) (ColorPickerPlayerColor.getScene().getWindow())).close();
    }
}
