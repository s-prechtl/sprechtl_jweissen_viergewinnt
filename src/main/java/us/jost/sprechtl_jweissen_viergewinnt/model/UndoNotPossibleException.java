package us.jost.sprechtl_jweissen_viergewinnt.model;


/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/

/**
 * Undo-Funktion ist nicht aufrufbar.
 *
 * @author : Stefan Prechtl
 * @date : 28.01.2022
 * @details Falls ein "undo" zum gewünschten Zeitpunkt nicht möglich ist, weil es der erste Zug ist/bereits 1x "undo"
 * verwendet wurde, so wird diese Exception geworfen
 */
public class UndoNotPossibleException extends Exception {
    /**
     * Konstruktor
     */
    public UndoNotPossibleException() {
        super("Undo not possible at the moment. Do another move first!");
    }
}
