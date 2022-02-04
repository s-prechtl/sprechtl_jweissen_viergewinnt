package us.jost.sprechtl_jweissen_viergewinnt.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import us.jost.sprechtl_jweissen_viergewinnt.VierGewinntApplication;

import java.io.IOException;

public class ControllerNamePickerGUI {

    public TextField LabelPlayerName;

    public static void display() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VierGewinntApplication.class.getResource("namePicker-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("NAME!");
        stage.setScene(scene);
        stage.show();
    }

    public void onConfirmButtonPressed() {
        ((Stage) (LabelPlayerName.getScene().getWindow())).close();
    }
}
