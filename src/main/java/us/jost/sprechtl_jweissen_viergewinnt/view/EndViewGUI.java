package us.jost.sprechtl_jweissen_viergewinnt.view;

import javafx.scene.control.Label;

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
 *   gibt den Spielausgang auf ein spezifiziertes Label aus
 */
public class EndViewGUI implements EndView {
    Label label;

    /**
     * initialisiert Attribute
     *
     * @param label Label, auf welches gschrieben werden soll
     */
    public EndViewGUI(Label label) {
        this.label = label;
    }


    /**
     * Dem gewinnenden Spieler wird gratuliert
     *
     * @param winnerName Name des Gewinners
     */
    @Override
    public void displayWin(String winnerName) {
        label.setText(winnerName + " has won! Congratulations!");
    }

    /**
     * Es wird ausgegeben, dass ein Unentschieden gespielt wurde
     */
    @Override
    public void displayTie() {
        label.setText("It's a tie!");
    }
}
