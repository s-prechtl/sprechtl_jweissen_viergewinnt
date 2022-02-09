package us.jost.sprechtl_jweissen_viergewinnt.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;

import java.util.ArrayList;
import java.util.HashMap;

/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 ----------------------------------------------------------------------------/
/**
 * Kurzbeschreibung
 *
 * @author  : Jonas Weissengruber
 * @date    : 04.02.2022
 *
 * @details
 *   Managed mit Hilfe der CellViewGUI die Anzeige des Spielbretts in der GUI
 */
public class BoardViewGUI {
    ArrayList<ArrayList<Circle>> board;
    CellViewGUI cellViewGUI;

    /**
     * initialisiert Attribute
     *
     * @param board  2D ArrayList aus Referenzen auf Circle-Instanzen, die die Zellen darstellen
     * @param colors Zuordnung von Spieler und der Farben ihrer Spielsteine
     */
    public BoardViewGUI(ArrayList<ArrayList<Circle>> board, HashMap<PlayerID, Color> colors) {
        this.board = board;
        cellViewGUI = new CellViewGUI(colors);
    }

    /**
     * setzt die Zelle an der Stelle (x|y) auf die Farbe des Spielers
     *
     * @param x        - Koordinate
     * @param y        - Koordinate
     * @param playerID Spieler, dessen Farbe dargestellt werden soll (null für leer)
     */
    public void updateCell(int x, int y, PlayerID playerID) {
        cellViewGUI.display(board.get(x).get(y), playerID);
    }

    /**
     * setzt alle Zellen des Spielfeldes auf leer / null
     */
    public void clear() {
        for (int x = 0; x < board.size(); x++) {
            for (int y = 0; y < board.get(0).size(); y++) {
                updateCell(x, y, null);
            }
        }
    }
}
