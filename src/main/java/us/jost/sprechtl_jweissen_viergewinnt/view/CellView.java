package us.jost.sprechtl_jweissen_viergewinnt.view;

import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;

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
 *   Stellt einzelne Zellen des Spielfeldes dar
 *
 */
public interface CellView {
    void display(PlayerID cell);
}
