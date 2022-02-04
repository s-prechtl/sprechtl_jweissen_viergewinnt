package us.jost.sprechtl_jweissen_viergewinnt.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import us.jost.sprechtl_jweissen_viergewinnt.VierGewinntApplication;
import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;
import us.jost.sprechtl_jweissen_viergewinnt.view.MessageView;
import us.jost.sprechtl_jweissen_viergewinnt.view.MessageViewGUI;

import java.io.IOException;
import java.util.HashMap;

/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/

/**
 * Controller für Color Picker
 *
 * @author : Stefan Prechtl
 * @date : 28.01.2022
 * @details Holt sich die gewünschte Farbe des jeweiligen Spielers.
 */
public class ControllerColorPickerGUI {

    public ColorPicker ColorPickerPlayerColor;
    public Label LabelError;

    private MessageView messageView;

    private final static HashMap<PlayerID, Color> playerColors = new HashMap<>();
    private final static HashMap<PlayerID, Color> defaultColors = new HashMap<>();

    /**
     * @return Stage zum darstellen der GUI
     * @throws IOException Falls das FXML-File nicht vorhanden ist
     */
    public static Stage getStage() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VierGewinntApplication.class.getResource("colorPicker-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("COLOR!");
        stage.setScene(scene);

        return stage;
    }

    /**
     * Automatisch von JFX aufgerufen.
     * Erstellt die messageView und setzt die Standardfarben + Startfarbe wird auf Std1 gesetzt.
     */
    public void initialize() {
        messageView = new MessageViewGUI(LabelError);
        defaultColors.put(PlayerID.Player0, Color.RED);
        defaultColors.put(PlayerID.Player1, Color.BLUE);
        ColorPickerPlayerColor.setValue(defaultColors.get(PlayerID.Player0));
    }

    /**
     * OnClick : Bast Button
     * Fügt, falls möglich, die gewählte Farbe für den momentanen Spieler ein.
     */
    public void onConfirmButtonPressed() {
        boolean success = false;
        Color temp = ColorPickerPlayerColor.getValue();
        PlayerID currPlayer = null;

        if (!temp.equals(Color.WHITE)) {
            if (playerColors.size() == 0) {
                success = true;
                currPlayer = PlayerID.Player0;
                ColorPickerPlayerColor.setValue(defaultColors.get(PlayerID.Player1));
            } else if (!playerColors.get(PlayerID.Player0).equals(temp)) {
                success = true;
                currPlayer = PlayerID.Player1;
            } else {
                messageView.display("Player's colors must not be equal!");
            }
        } else {
            messageView.display("Player's color must not be white!");
        }

        if (success) {
            messageView.display("");
            playerColors.put(currPlayer, temp);
            ((Stage) (ColorPickerPlayerColor.getScene().getWindow())).close();
        }
    }

    /**
     * @return Die gewählten Farben als HashMap zugeordnet zu den Spielern.
     */
    public static HashMap<PlayerID, Color> getPlayerColors() {
        return playerColors;
    }
}
