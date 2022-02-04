package us.jost.sprechtl_jweissen_viergewinnt.controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import us.jost.sprechtl_jweissen_viergewinnt.VierGewinntApplication;
import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;
import us.jost.sprechtl_jweissen_viergewinnt.view.MessageView;
import us.jost.sprechtl_jweissen_viergewinnt.view.MessageViewGUI;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ControllerColorPickerGUI {

    public ColorPicker ColorPickerPlayerColor;
    public Label LabelError;

    private MessageView messageView;

    private final static HashMap<PlayerID, Color> playerColors = new HashMap<>();
    private final static HashMap<PlayerID, Color> defaultColors = new HashMap<>();

    public static Stage getStage() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VierGewinntApplication.class.getResource("colorPicker-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("COLOR!");
        stage.setScene(scene);

        return stage;
    }

    public void initialize(){
        messageView = new MessageViewGUI(LabelError);
        defaultColors.put(PlayerID.Player0, Color.RED);
        defaultColors.put(PlayerID.Player1, Color.BLUE);
        ColorPickerPlayerColor.setValue(defaultColors.get(PlayerID.Player0));
    }

    public void onConfirmButtonPressed() {
        boolean success = false;
        Color temp = ColorPickerPlayerColor.getValue();
        PlayerID currPlayer = null;

        if (!temp.equals(Color.WHITE)){
            if(playerColors.size() == 0){
                success = true;
                currPlayer = PlayerID.Player0;
                ColorPickerPlayerColor.setValue(defaultColors.get(PlayerID.Player1));
            }else if (!playerColors.get(PlayerID.Player0).equals(temp)){
                success = true;
                currPlayer = PlayerID.Player1;
            }else {
                messageView.display("Player's colors must not be equal!");
            }
        }else{
            messageView.display("Player's color must not be white!");
        }

        if (success){
            playerColors.put(currPlayer, temp);
            ((Stage) (ColorPickerPlayerColor.getScene().getWindow())).close();
        }
    }

    public static HashMap<PlayerID, Color> getPlayerColors() {
        return playerColors;
    }
}
