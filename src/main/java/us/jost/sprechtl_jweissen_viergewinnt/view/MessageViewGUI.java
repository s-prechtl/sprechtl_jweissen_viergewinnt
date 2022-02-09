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
 *   Gibt Text auf ein Spezifiziertes Label der GUI aus
 */
public class MessageViewGUI implements MessageView {
    Label label;

    /**
     * initialisiert Attribute
     *
     * @param label Label, auf welches geschrieben werden soll
     */
    public MessageViewGUI(Label label) {
        this.label = label;
    }

    /**
     * setzt den Text des labels
     *
     * @param msg zu setzender Text
     */
    @Override
    public void display(String msg) {
        label.setText(msg);
    }
}
