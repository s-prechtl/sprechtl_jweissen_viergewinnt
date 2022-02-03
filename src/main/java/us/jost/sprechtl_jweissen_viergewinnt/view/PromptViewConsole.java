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
 *   Gibt eine Nachricht aus, die einen bestimmten Spieler auffordert, einen Line-Input zu machen
 *
 */


package us.jost.sprechtl_jweissen_viergewinnt.view;


public class PromptViewConsole implements PromptView {
    @Override
    public void display(String playerName, String msg) {
        System.out.println("[" + playerName + "] " + msg);
    }
}
