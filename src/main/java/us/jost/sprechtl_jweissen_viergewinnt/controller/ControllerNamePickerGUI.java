package us.jost.sprechtl_jweissen_viergewinnt.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import us.jost.sprechtl_jweissen_viergewinnt.VierGewinntApplication;
import us.jost.sprechtl_jweissen_viergewinnt.model.Player;
import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;
import us.jost.sprechtl_jweissen_viergewinnt.view.MessageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ControllerNamePickerGUI {

    public TextField LabelPlayerName;
    public Label LabelError;

    private MessageView messageView;

    private final static HashMap<PlayerID, String> playerNames = new HashMap<>();

    public static Stage getStage() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VierGewinntApplication.class.getResource("namePicker-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("NAME!");
        stage.setScene(scene);

        return stage;
    }

    public void initialize(){
        //TODO: messageView
    }

    public void onConfirmButtonPressed() {
        boolean success = false;
        String temp = LabelPlayerName.getText();
        PlayerID currplayer = null;

        if (!temp.equals("")){
            if(playerNames.size() == 0){
                success = true;
                currplayer = PlayerID.Player0;
            }else if (!playerNames.get(PlayerID.Player0).equals(temp)){
                success = true;
                currplayer = PlayerID.Player1;
            }else {
                messageView.display("Player's names must not be equal!");
            }
        }else{
            messageView.display("Player name must not be empty!");
        }

        if (success){
            playerNames.put(currplayer, temp);
            LabelPlayerName.clear();
            ((Stage) (LabelPlayerName.getScene().getWindow())).close();
        }
    }

    public static HashMap<PlayerID, String> getPlayerNames() {
        return playerNames;
    }
}
