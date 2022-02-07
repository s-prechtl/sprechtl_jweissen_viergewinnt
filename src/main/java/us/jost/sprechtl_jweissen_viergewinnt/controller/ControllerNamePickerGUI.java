package us.jost.sprechtl_jweissen_viergewinnt.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
 * Controller für die Namenseingabe
 *
 * @author : Stefan Prechtl
 * @date : 28.01.2022
 * @details Holt sich den gewünschten Namen des jeweiligen Spielers.
 */
public class ControllerNamePickerGUI {

    public TextField LabelPlayerName;
    public Label LabelError;

    private MessageView messageView;

    private final static HashMap<PlayerID, String> playerNames = new HashMap<>();

    /**
     * @return Stage zum darstellen der GUI
     * @throws IOException Falls das FXML-File nicht vorhanden ist
     */
    public static Stage getStage() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VierGewinntApplication.class.getResource("namePicker-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("NAME!");
        stage.setScene(scene);

        return stage;
    }

    /**
     * Automatisch von JFX aufgerufen.
     * Erstellt die messageView.
     */
    public void initialize() {
        messageView = new MessageViewGUI(LabelError);
    }

    /**
     * Event: OnClick
     * Ruft confirmName auf.
     */
    public void onConfirmButtonPressed() {
        confirmName();
    }

    /**
     * @return Die gewählten Namen als HashMap zugeordnet zu den Spielern.
     */
    public static HashMap<PlayerID, String> getPlayerNames() {
        return playerNames;
    }

    /**
     * Falls Key == Enter -> confirmName
     * @param keyEvent Key
     */
    public void onKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            confirmName();
        }
    }

    /**
     * Fügt, falls möglich, den gewählten Namen für den momentanen Spieler ein.
     */
    private void confirmName(){
        boolean success = false;
        String temp = LabelPlayerName.getText();
        PlayerID currplayer = null;

        if (!temp.equals("")) {
            if (playerNames.size() == 0) {
                success = true;
                currplayer = PlayerID.Player0;
            } else if (!playerNames.get(PlayerID.Player0).equals(temp)) {
                success = true;
                currplayer = PlayerID.Player1;
            } else {
                messageView.display("Player's names must not be equal!");
            }
        } else {
            messageView.display("Player name must not be empty!");
        }

        if (success) {
            messageView.display("");
            playerNames.put(currplayer, temp);
            LabelPlayerName.clear();
            ((Stage) (LabelPlayerName.getScene().getWindow())).close();
        }
    }
}
