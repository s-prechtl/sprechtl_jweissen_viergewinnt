package us.jost.sprechtl_jweissen_viergewinnt.view;

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
 *   gibt am Ende des Spieles den Ausgang aus
 */
public interface EndView {
    void displayWin(String winnerName);

    void displayTie();
}
