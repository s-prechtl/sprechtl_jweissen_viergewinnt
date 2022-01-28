package us.jost.sprechtl_jweissen_viergewinnt.model;


/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author  : Stefan Prechtl
 * @date    : 28.01.2022
 *
 * @details
 *   Falls angegebene Position nicht im Feld liegt, wird diese Exception geworfen.
 *
 */
public class InvalidPositionException extends Exception{
    public InvalidPositionException() {
        super("This postion isn't valid!");
    }
}
