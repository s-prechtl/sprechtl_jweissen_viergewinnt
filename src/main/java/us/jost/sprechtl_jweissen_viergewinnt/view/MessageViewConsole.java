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
 *   Wird benutzt um Nachrichten an die Spieler in der Konsole dazustellen
 *   (Informiert zB wer gewonnen hat)
 */

package us.jost.sprechtl_jweissen_viergewinnt.view;

public class MessageViewConsole implements MessageView {
    @Override
    public void display(String msg) {
        System.out.println(msg);
    }
}
