package us.jost.sprechtl_jweissen_viergewinnt.model;

import java.util.ArrayList;


/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Spielbrett
 *
 * @author  : Stefan Prechtl
 * @date    : 28.01.2022
 *
 * @details
 *   Board, das zur Verwaltung der Cell-Daten verwendet wird.
 *
 */
public class Board {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final int WINDIST = 4;
    private final ArrayList<ArrayList<Cell>> board = new ArrayList<>();
    private Cell previouslyChanged;

    /**
     * Konstruktor: Initialisiert das Spielbrett.
     */
    public Board() {
        for (int x = 0; x < COLS; x++) {
            board.add(new ArrayList<>());
            for (int y = 0; y < ROWS; y++) {
                board.get(x).add(new Cell(x, y));
            }
        }
        previouslyChanged = null;
    }

    /**
     * @param x Spalte
     * @param y Reihe
     * @return If given position is in the boundaries of ROWS/COLS
     */
    private static boolean inArea(int x, int y) {
        return (x < COLS) && (x >= 0) && (y < ROWS) && (y >= 0);
    }

    /**
     * @return Ob das Spiel gewonnen wurde.
     */
    public boolean checkWin() {
        if (previouslyChanged != null) {
            int winCount = 0;
            PlayerID playerID = previouslyChanged.getState();
            int x = previouslyChanged.getX();
            int y = previouslyChanged.getY();
            int ix;
            int iy;
            boolean isWin = false;

            //horizontal
            for (ix = initI_negative(x); inArea(ix, y) && !isWin; ix++) {
                if (accessCell(ix, y).getState() == playerID) {
                    winCount++;
                } else {
                    winCount = 0;
                }
                if (winCount >= WINDIST) {
                    isWin = true;
                }
            }

            //vertical
            winCount = 0;
            for (iy = initI_negative(y); inArea(x, iy) && !isWin; iy++) {
                if (accessCell(x, iy).getState() == playerID) {
                    winCount++;
                } else {
                    winCount = 0;
                }
                if (winCount >= WINDIST) {
                    isWin = true;
                }
            }

            //left up to right down
            winCount = 0;
            for (ix = initI_negative(x, Math.min(x,y)), iy = initI_negative(y, Math.min(x,y)); inArea(ix, iy) && !isWin; ix++, iy++) {
                if (accessCell(ix, iy).getState() == playerID) {
                    winCount++;
                } else {
                    winCount = 0;
                }
                if (winCount >= WINDIST) {
                    isWin = true;
                }
            }

            //right up to left down
            winCount = 0;
            for (ix = initI_negative(x, Math.max(x,y)), iy = initI_positive(y, Math.max(x,y)); inArea(ix, iy) && !isWin; ix++, iy--) {
                if (accessCell(ix, iy).getState() == playerID) {
                    winCount++;
                } else {
                    winCount = 0;
                }
                if (winCount >= WINDIST) {
                    isWin = true;
                }
            }

            return isWin;
        }
        return false;
    }

    /**
     * @param z Wert
     * @return Minimalwert zum Ende des Feldes, bzw. zur WINDIST=4
     */
    private int initI_negative(int z) {
        return Math.max(z - WINDIST, 0);
    }

    /**
     * @param z Wert
     * @param dist Maximale Distanz zum Subtrahieren
     * @return Maximalwert zum Ende des Feldes, bzw. zur dist
     */
    private int initI_negative(int z, int dist) {
        return Math.max(z - dist, 0);
    }

    /**
     * @param z Wert
     * @param dist Maximale Distanz zum Addieren
     * @return Maximalwert zum Ende des Feldes, bzw. zur dist
     */
    private int initI_positive(int z, int dist) {
        return (z + dist >= ROWS) ? ROWS - 1 : z + dist;
    }

    /**
     * @return Ob das Spiel ein Unentschieden ist.
     */
    public boolean checkTie() {
        boolean isTie = true;
        for (int x = 0; x < COLS && isTie; x++) {
            for (int y = 0; y < ROWS && isTie; y++) {

                if (accessCell(x, y).getState() == null) {
                    isTie = false;
                }

            }
        }
        return isTie;
    }

    /**
     * @return Vereinfachte Liste des boards, auf welchem die Zellen nur durch ihren Wert/State angegeben werden.
     */
    public ArrayList<ArrayList<PlayerID>> boardToPlayerIDs() {
        ArrayList<ArrayList<PlayerID>> boardIDs = new ArrayList<>();

        for (int x = 0; x < COLS; x++) {
            boardIDs.add(new ArrayList<>());
            for (int y = 0; y < ROWS; y++) {
                boardIDs.get(x).add(accessCell(x, y).getState());
            }
        }

        return boardIDs;
    }

    /**
     * @param col Spalte
     * @return Nächster freier Platz in der Spalte
     * @throws InvalidPositionException Falls die Spalte bereits voll ist.
     */
    public int getNextFreeRow(int col) throws InvalidPositionException {
        int nextFreeRow = -1;

        for (int y = 0; y < ROWS && nextFreeRow == -1; y++) {
            if (accessCell(col, y).getState() == null) {
                nextFreeRow = y;
            }
        }
        if (nextFreeRow == -1) {
            throw new InvalidPositionException();
        }
        return nextFreeRow;
    }

    public Cell accessCell(int x, int y) {
        return board.get(x).get(y);
    }

    public Cell getPreviouslyChanged() {
        return previouslyChanged;
    }

    public void setPreviouslyChanged(Cell previouslyChanged) {
        this.previouslyChanged = previouslyChanged;
    }
}
