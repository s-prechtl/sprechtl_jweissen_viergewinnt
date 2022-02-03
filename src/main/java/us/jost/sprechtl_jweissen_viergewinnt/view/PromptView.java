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
 *   Fragt einen bestimmten Spieler nach einem Text-Input
 *
 */
package us.jost.sprechtl_jweissen_viergewinnt.view;

public interface PromptView {
    void display(String playerName, String msg);
}
