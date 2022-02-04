package us.jost.sprechtl_jweissen_viergewinnt.view;

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
 * @date    : 28.01.2022
 *
 * @details
 *   Stellt einzelne Zellen des Spielfeldes basierend auf dessen Inhalt an
 *   Wird von BoardViewConsole verwendet um das Spielfeld darzustellen
 */
public class CellViewConsole implements CellView {
    private HashMap<PlayerID, Character> symbols;

    public CellViewConsole(HashMap<PlayerID, Character> symbols) {
        this.symbols = symbols;
    }

    /**
     * Löst den cell-Parameter in das in symbols spezifizierte Spielsymbol des jeweiligen Spielers auf
     * Stellt dann eine einzelne Zelle in der Konsole mit dem entsprechendem Symbol dar.
     * Gilt cell == null, ist das Feld noch nicht besetzt und es wird eine leere Zelle dargestellt
     *
     * @param cell gibt den Speiler an, welcher dieses Feld besetzt.
     */
    @Override
    public void display(PlayerID cell) {
        char chrToDisplay;
        if (cell != null) {
            chrToDisplay = symbols.get(cell);
        } else {
            chrToDisplay = ' ';
        }
        System.out.printf("[%c]", chrToDisplay);
    }
}
