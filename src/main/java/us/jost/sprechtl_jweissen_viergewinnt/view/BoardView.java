package us.jost.sprechtl_jweissen_viergewinnt.view;

import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;

import java.util.ArrayList;

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
 *   Implementierende Klassen nutzen die display()-Methode um das Spielfeld darzustellen
 *
 */
public interface BoardView {
    void display(ArrayList<ArrayList<PlayerID>> board);
}
