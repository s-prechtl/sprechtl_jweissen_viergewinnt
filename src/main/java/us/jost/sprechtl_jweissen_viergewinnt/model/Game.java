package us.jost.sprechtl_jweissen_viergewinnt.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Spiel
 *
 * @author  : Stefan Prechtl
 * @date    : 28.01.2022
 *
 * @details
 *   Verwaltet Board und Spieler, welche darauf agieren.
 *
 */
public class Game {
    private final HashMap<PlayerID, Player> players = new HashMap<>();
    private PlayerID currPlayer;
    private Board board;

    /**
     * Konstruktor: Erstellt Board und Spieler, welche damit agieren.
     * @param name1 Name des 1. Spielers
     * @param name2 Name des 2. Spielers
     */
    public Game(String name1, String name2) {
        board = new Board();

        players.put(PlayerID.Player0, new Player(name1));
        players.put(PlayerID.Player1, new Player(name2));
        randomizePlayers();
    }

    /**
     * Bestimmt einen zufälligen currPlayer.
     */
    private void randomizePlayers() {
        currPlayer = (Math.abs(new Random().nextInt() % 2) == 0) ? PlayerID.Player0 : PlayerID.Player1;
    }

    /**
     * Setzt den Fortschritt des Spiels zurück.
     */
    public void reset() {
        board = new Board();
        randomizePlayers();
    }

    /**
     * Macht den letzten Spielzug rückgängig.
     * @throws UndoNotPossibleException Falls undo am ersten Zug aufgerufen wird, oder undo mehrmals hintereinander
     * aufgerufen wird.
     */
    public void undo() throws UndoNotPossibleException {
        if (board.getPreviouslyChanged() == null){
            throw new UndoNotPossibleException();
        }
        board.getPreviouslyChanged().setState(null);
        board.setPreviouslyChanged(null);
        switchCurrPlayer();
    }

    /**
     * Spielt einen Zug in der angegebenen Spalte.
     * @param col Spalte zum Setzen der Zuges.
     * @throws IllegalArgumentException Falls die Spalte bereits voll ist.
     */
    public void play(int col) throws InvalidPositionException {
        int y = board.getNextFreeRow(col);

        board.accessCell(col, y).setState(currPlayer);
        board.setPreviouslyChanged(board.accessCell(col, y));
    }

    /**
     * Wechselt den currPlayer
     */
    public void switchCurrPlayer() {
        currPlayer = (currPlayer == PlayerID.Player0) ? PlayerID.Player1 : PlayerID.Player0;
    }

    /**
     * @param playerID Zur Identifizierung
     * @return Namen des identifizierten Spielers
     */
    public String getPlayerName(PlayerID playerID) {
        return players.get(playerID).getName();
    }

    /**
     * @return Momentanen Spieler
     */
    public PlayerID getCurrPlayer() {
        return currPlayer;
    }

    /**
     * @return Ob das Spiel gewonnen wurde.
     */
    public boolean checkWin(){
        return board.checkWin();
    }

    /**
     * @return Ob das Spiel ein Unentschieden ist.
     */
    public boolean checkTie(){
        return board.checkTie();
    }

    /**
     * @return Vereinfachte Liste des boards, auf welchem die Zellen nur durch ihren Wert/State angegeben werden.
     */
    public ArrayList<ArrayList<PlayerID>> getPlayerIDBoard(){
        return board.boardToPlayerIDs();
    }
}
