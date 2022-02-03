package us.jost.sprechtl_jweissen_viergewinnt.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerGUI {
    @FXML
    private Label LabelMessage;

    public void onButtonUndoClicked() {
    }

    public void onButtonResetClicked() {
    }

    public void onButtonQuitClicked() {
        Platform.exit();
    }
}