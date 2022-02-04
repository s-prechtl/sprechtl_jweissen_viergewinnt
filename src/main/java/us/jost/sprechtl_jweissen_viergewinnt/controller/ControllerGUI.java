package us.jost.sprechtl_jweissen_viergewinnt.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import us.jost.sprechtl_jweissen_viergewinnt.model.Game;
import us.jost.sprechtl_jweissen_viergewinnt.model.Player;
import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;
import us.jost.sprechtl_jweissen_viergewinnt.view.MessageView;

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
        //TODO: messageviewGUI
    }

    public void init(Stage namePicker, Stage colorPicker){
        this.namePicker = namePicker;
        this.colorPicker = colorPicker;



//        game = new Game();
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