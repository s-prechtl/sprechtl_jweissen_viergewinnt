package us.jost.sprechtl_jweissen_viergewinnt.model;


/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/

/**
 * Zelle
 *
 * @author : Stefan Prechtl
 * @date : 28.01.2022
 * @details Zur Datenbereitstellung für das Board.
 */
public class Cell {
    private final int x;
    private final int y;
    private PlayerID state;

    /**
     * Konstruktor: Initialisiert den Platz der Zelle und setzt den Wert/State auf null
     *
     * @param x Spalte
     * @param y Reihe
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        state = null;
    }

    /**
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * @return Wert/State
     */
    public PlayerID getState() {
        return state;
    }

    /**
     * Setzt den Wert/State einer Zelle
     *
     * @param state Wert/State
     */
    public void setState(PlayerID state) {
        this.state = state;
    }
}
