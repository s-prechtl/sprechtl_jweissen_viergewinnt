package us.jost.sprechtl_jweissen_viergewinnt.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Game {
    private final HashMap<PlayerID, Player> players = new HashMap<>();
    private PlayerID currPlayer;
    private Board board;

    public Game(String name1, String name2) {
        board = new Board();

        players.put(PlayerID.Player0, new Player(name1));
        players.put(PlayerID.Player1, new Player(name2));
        randomizePlayers();
    }

    /**
     * Chooses a random player to begin the game.
     */
    private void randomizePlayers() {
        currPlayer = (Math.abs(new Random().nextInt() % 2) == 0) ? PlayerID.Player0 : PlayerID.Player1;
    }

    public void reset() {
        board = new Board();
        randomizePlayers();
    }

    /**
     * @throws UndoNotPossibleException If prevChanged is null. If its move no. 1, or undo has been called before
     */
    public void undo() throws UndoNotPossibleException {
        if (board.getPreviouslyChanged() == null){
            throw new UndoNotPossibleException();
        }
        board.getPreviouslyChanged().setState(null);
        switchCurrPlayer();
    }

    /**
     * Plays a move in given column.
     *
     * @throws IllegalArgumentException If column is already full.
     */
    public void play(int col) throws InvalidPositionException {
        int y = board.getNextFreeRow(col);

        board.accessCell(col, y).setState(currPlayer);
        board.setPreviouslyChanged(board.accessCell(col, y));
    }

    public void switchCurrPlayer() {
        currPlayer = (currPlayer == PlayerID.Player0) ? PlayerID.Player1 : PlayerID.Player0;
    }

    public String getPlayerName(PlayerID playerID) {
        return players.get(playerID).getName();
    }

    public PlayerID getCurrPlayer() {
        return currPlayer;
    }

    public boolean checkWin(){
        return board.checkWin();
    }

    public boolean checkTie(){
        return board.checkTie();
    }

    public ArrayList<ArrayList<PlayerID>> getPlayerIDBoard(){
        return board.boardToPlayerIDs();
    }
}
