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
 *   Zur Datenbereitstellung für das Board.
 *
 */
public class Cell {
    private final int x;
    private final int y;
    private PlayerID state;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        state = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PlayerID getState() {
        return state;
    }

    public void setState(PlayerID state) {
        this.state = state;
    }
}
