package us.jost.sprechtl_jweissen_viergewinnt.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;

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
 *   Updated einzelne Zellen im GUI-Spielfeld
 */
public class CellViewGUI {
    private final HashMap<PlayerID, Color> colors;

    /**
     * initialisiert Attribute
     *
     * @param colors Spieler und ihre zugeordneten Spielsteinfarben
     */
    public CellViewGUI(HashMap<PlayerID, Color> colors) {
        this.colors = colors;
    }

    /**
     * setzt die Farbe des übergebenen Circles auf die Farbe des übergebenen Spielers
     *
     * @param cell     Referenz auf den Circle, der die Cell darstellt
     * @param playerID Player, dessen Farbe dargestellt werden soll. (null = leer)
     */
    public void display(Circle cell, PlayerID playerID) {
        Color color;
        if (playerID != null) {
            color = colors.get(playerID);
        } else {
            color = Color.WHITE;
        }
        cell.setFill(color);
    }
}
