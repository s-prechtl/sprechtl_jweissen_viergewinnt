package us.jost.sprechtl_jweissen_viergewinnt.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import us.jost.sprechtl_jweissen_viergewinnt.model.*;
import us.jost.sprechtl_jweissen_viergewinnt.view.BoardViewGUI;
import us.jost.sprechtl_jweissen_viergewinnt.view.MessageView;
import us.jost.sprechtl_jweissen_viergewinnt.view.MessageViewGUI;

import java.util.ArrayList;
import java.util.HashMap;

public class ControllerGUI {
    public HBox HBoxField;
    @FXML
    private Label LabelMessage;

    private Stage namePicker;
    private Stage colorPicker;
    private Game game;
    private MessageView messageView;
    BoardViewGUI boardView;

    private static ControllerGUI controllerGUI;

    public ControllerGUI() {
        controllerGUI = this;
    }

    public void initialize(){
        messageView = new MessageViewGUI(LabelMessage);
        addListeners();
    }

    private void addListeners(){
        int x = 0;
        while (x < HBoxField.getChildren().size()){
            Node col = (Node) HBoxField.getChildren().get(x);
            if (col instanceof VBox){
                int finalX = x;
                col.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent click) {
                        tryPlace(finalX);
                    }
                });
            }
            x++;
        }

    }

    private ArrayList<ArrayList<Circle>> getAllCircles(){
        ArrayList<ArrayList<Circle>> circles = new ArrayList<>();
        int x = HBoxField.getChildren().size()-1;
        int y;

        while (x >= 0){
            if (HBoxField.getChildren().get(x) instanceof VBox){
                VBox col = (VBox) HBoxField.getChildren().get(x);
                circles.add(new ArrayList<>());
                y = col.getChildren().size()-1;
                while (y >= 0) {
                    if (col.getChildren().get(y) instanceof Circle){
                        Circle circle = (Circle) col.getChildren().get(y);
                        circles.get(x).add(circle);
                        y--;
                    }

                }
            }
            x--;
        }

        return circles;
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

        //intit Boardview
        boardView = new BoardViewGUI(getAllCircles(), playerColors);

        game = new Game(playerNames.get(PlayerID.Player0), playerNames.get(PlayerID.Player1));
    }

    /**
     * versucht einen Spielstein zu platzieren, sollte dies nicht möglich sein,
     * wird eine Error-Message ausgegeben
     * @param col die Spalte, in die gesetzt werden soll
     */
    private void tryPlace(int col) {
        try {
            game.play(col);
            game.switchCurrPlayer();
            boardView.updateCell(game.getPrevCell().getX(), game.getPrevCell().getY(), game.getCurrPlayer());
        } catch (InvalidPositionException ipe) {
            messageView.display(ipe.getMessage());
        }
    }

    /**
     * versucht, den letzten Move rückgängig zu machen, sollte dies nicht möglich sein,
     * wird eine Error-Message ausgegeben
     */
    public void onButtonUndoClicked() {
        try {
            game.undo();
            messageView.display("Last move undone!");
            boardView.updateCell(game.getPrevCell().getX(), game.getPrevCell().getY(), game.getCurrPlayer());
        } catch (UndoNotPossibleException unpe) {
            messageView.display(unpe.getMessage());
        }
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