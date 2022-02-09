package us.jost.sprechtl_jweissen_viergewinnt.model;


/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/

/**
 * Spieler
 *
 * @author : Stefan Prechtl
 * @date : 28.01.2022
 * @details Verwaltet den Namen eines Spielers
 */
public class Player {
    private final String name;

    /**
     * Konstruktor: Setzt den Namen des Spielers
     *
     * @param name Name
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return Name des Spielers
     */
    public String getName() {
        return name;
    }
}
