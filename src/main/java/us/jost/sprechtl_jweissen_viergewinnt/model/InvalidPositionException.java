package us.jost.sprechtl_jweissen_viergewinnt.model;


/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Position nicht verfügbar.
 *
 * @author  : Stefan Prechtl
 * @date    : 28.01.2022
 *
 * @details
 *   Falls angegebene Position nicht im Feld liegt, oder die gewünschte Reihe bereits voll ist, wird diese Exception geworfen.
 *
 */
public class InvalidPositionException extends Exception{
    /**
     * Konstruktor
     */
    public InvalidPositionException() {
        super("This postion isn't valid!");
    }
}
