package us.jost.sprechtl_jweissen_viergewinnt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import us.jost.sprechtl_jweissen_viergewinnt.controller.ControllerColorPickerGUI;
import us.jost.sprechtl_jweissen_viergewinnt.controller.ControllerGUI;
import us.jost.sprechtl_jweissen_viergewinnt.controller.ControllerNamePickerGUI;

import java.io.IOException;

/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/

/**
 * Anwendung
 *
 * @author : Stefan Prechtl
 * @date : 28.01.2022
 * @details Startet das GUI
 */
public class VierGewinntApplication extends Application {
    /**
     * Startet die Anwendung
     *
     * @param stage Hauptfenster des GUI
     * @throws IOException Falls FXML-File des Hauptfensters nicht vorhanden
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VierGewinntApplication.class.getResource("vierGewinnt-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("VIER GEWINNT!");
        stage.setScene(scene);

        Stage colorPicker = ControllerColorPickerGUI.getStage();
        Stage namePicker = ControllerNamePickerGUI.getStage();

        stage.show();
        ControllerGUI.getControllerGUI().init(namePicker, colorPicker);
    }

    /**
     * Startet das Programm.
     */
    public static void main(String[] args) {
        launch();
    }
}