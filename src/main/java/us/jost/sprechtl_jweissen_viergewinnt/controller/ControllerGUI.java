package us.jost.sprechtl_jweissen_viergewinnt.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import us.jost.sprechtl_jweissen_viergewinnt.model.Game;
import us.jost.sprechtl_jweissen_viergewinnt.model.Player;
import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;
import us.jost.sprechtl_jweissen_viergewinnt.view.MessageView;
import us.jost.sprechtl_jweissen_viergewinnt.view.MessageViewGUI;

import java.util.ArrayList;
import java.util.HashMap;

public class ControllerGUI {
    @FXML
    private Label LabelMessage;

    private Stage namePicker;
    private Stage colorPicker;
    private Game game;
    private MessageView messageView;

    private static ControllerGUI controllerGUI;

    public ControllerGUI() {
        controllerGUI = this;
    }

    public void initialize(){
        messageView = new MessageViewGUI(LabelMessage);
    }

    public void init(Stage namePicker, Stage colorPicker){
        this.namePicker = namePicker;
        this.colorPicker = colorPicker;
        HashMap<PlayerID, String> playerNames;
        HashMap<PlayerID, Color> playerColors;

        this.namePicker.setTitle(PlayerID.Player0.toString());
        this.namePicker.showAndWait();
        this.namePicker.setTitle(PlayerID.Player1.toString());
        this.namePicker.showAndWait();

        playerNames = ControllerNamePickerGUI.getPlayerNames();

        this.colorPicker.setTitle(playerNames.get(PlayerID.Player0));
        this.colorPicker.showAndWait();
        this.colorPicker.setTitle(playerNames.get(PlayerID.Player1));
        this.colorPicker.showAndWait();

        playerColors = ControllerColorPickerGUI.getPlayerColors();

        game = new Game(playerNames.get(PlayerID.Player0), playerNames.get(PlayerID.Player1));
    }

    public void onButtonUndoClicked() {

    }

    public void onButtonResetClicked() {
    }

    public void onButtonQuitClicked() {
        Platform.exit();
    }

    public static ControllerGUI getControllerGUI() {
        return controllerGUI;
    }
}