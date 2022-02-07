package us.jost.sprechtl_jweissen_viergewinnt.controller;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import us.jost.sprechtl_jweissen_viergewinnt.model.Game;
import us.jost.sprechtl_jweissen_viergewinnt.model.InvalidPositionException;
import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;
import us.jost.sprechtl_jweissen_viergewinnt.model.UndoNotPossibleException;
import us.jost.sprechtl_jweissen_viergewinnt.view.*;

import java.util.ArrayList;
import java.util.HashMap;

/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/

/**
 * Controller des Hauptfensters
 *
 * @author : Stefan Prechtl
 * @date : 28.01.2022
 * @details Verwaltet Daten zum Spiel verbindet Ausgabe mit Eingabe und Spiel
 */
public class ControllerGUI {
    public HBox HBoxField;
    @FXML
    private Label LabelMessage;

    private Game game;
    private MessageView messageView;
    private EndView endView;
    BoardViewGUI boardView;

    private static ControllerGUI controllerGUI;

    /**
     * Konstruktor zum setzen der static controllerGUI Variable.
     */
    public ControllerGUI() {
        controllerGUI = this;
    }

    /**
     * Automatisch von JFX aufgerufen.
     * Erstellt Messageview, Endview und legt die Listener an.
     */
    public void initialize() {
        messageView = new MessageViewGUI(LabelMessage);
        endView = new EndViewGUI(LabelMessage);
        addListeners();
    }

    /**
     * Legt die Listener für die Spalten des Spielfelds an.
     */
    private void addListeners() {
        int x = 0;
        while (x < HBoxField.getChildren().size()) {
            if (HBoxField.getChildren().get(x) instanceof VBox) {
                VBox col = (VBox) HBoxField.getChildren().get(x);
                int finalX = x;
                col.setOnMouseClicked(click -> {
                    if (!(game.checkTie() || game.checkWin())) {
                        tryPlace(finalX);

                        if (game.checkWin()) {
                            endView.displayWin(game.getPlayerName(game.getCurrPlayer()));
                        } else if (game.checkTie()) {
                            endView.displayTie();
                        } else {
                            updateMessageView();
                        }
                    }

                });
            }
            x++;
        }

    }

    /**
     * @return Alle Kreise.
     */
    private ArrayList<ArrayList<Circle>> getAllCircles() {
        ArrayList<ArrayList<Circle>> circles = new ArrayList<>();
        int x = 0;
        int y;

        while (x < HBoxField.getChildren().size()) {
            if (HBoxField.getChildren().get(x) instanceof VBox) {
                VBox col = (VBox) HBoxField.getChildren().get(x);
                circles.add(new ArrayList<>());
                y = col.getChildren().size() - 1;
                while (y >= 0) {
                    if (col.getChildren().get(y) instanceof Circle) {
                        Circle circle = (Circle) col.getChildren().get(y);
                        circles.get(x).add(circle);
                        y--;
                    }

                }
            }
            x++;
        }

        return circles;
    }

    public void init(Stage namePicker, Stage colorPicker) {
        HashMap<PlayerID, String> playerNames;
        HashMap<PlayerID, Color> playerColors;

        namePicker.setTitle(PlayerID.Player0.toString());
        namePicker.showAndWait();
        namePicker.setTitle(PlayerID.Player1.toString());
        namePicker.showAndWait();

        playerNames = ControllerNamePickerGUI.getPlayerNames();

        colorPicker.setTitle(playerNames.get(PlayerID.Player0));
        colorPicker.showAndWait();
        colorPicker.setTitle(playerNames.get(PlayerID.Player1));
        colorPicker.showAndWait();

        playerColors = ControllerColorPickerGUI.getPlayerColors();

        //intit Boardview
        boardView = new BoardViewGUI(getAllCircles(), playerColors);

        game = new Game(playerNames.get(PlayerID.Player0), playerNames.get(PlayerID.Player1));
        updateMessageView();
    }

    /**
     * Versucht einen Spielstein zu platzieren, sollte dies nicht möglich sein,
     * wird eine Error-Message ausgegeben.
     *
     * @param col die Spalte, in die gesetzt werden soll
     */
    private void tryPlace(int col) {
        try {
            game.play(col);
            boardView.updateCell(game.getPrevCell().getX(), game.getPrevCell().getY(), game.getCurrPlayer());
            if (!game.checkWin()){
                game.switchCurrPlayer();
            }
        } catch (InvalidPositionException ipe) {
            messageView.display(ipe.getMessage());
        }
    }

    /**
     * OnClick: Undo Button
     * Versucht, den letzten Move rückgängig zu machen, sollte dies nicht möglich sein,
     * wird eine Error-Message ausgegeben.
     */
    public void onButtonUndoClicked() {
        try {
            boardView.updateCell(game.getPrevCell().getX(), game.getPrevCell().getY(), null);
            game.undo();
            messageView.display("Last move undone!");
        } catch (UndoNotPossibleException unpe) {
            messageView.display(unpe.getMessage());
        } catch (NullPointerException npe) {
            messageView.display(new UndoNotPossibleException().getMessage());
        }
    }

    /**
     * OnClick: Reset Button
     * Setzt das Spiel zurück.
     */
    public void onButtonResetClicked() {
        game.reset();
        boardView.clear();
        updateMessageView();
    }

    /**
     * OnClick: Quit Button
     * Beendet das Programm.
     */
    public void onButtonQuitClicked() {
        Platform.exit();
    }

    /**
     * @return Instanz des Spiels
     */
    public static ControllerGUI getControllerGUI() {
        return controllerGUI;
    }

    /**
     * Zeigt den derzeitigen Spieler in der messageView an.
     */
    private void updateMessageView(){
        messageView.display(game.getPlayerName(game.getCurrPlayer()) + "'s move.");
    }
}