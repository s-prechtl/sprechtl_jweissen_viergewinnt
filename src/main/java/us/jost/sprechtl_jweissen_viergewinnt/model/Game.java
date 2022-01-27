package us.jost.sprechtl_jweissen_viergewinnt.model;

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

    private void randomizePlayers(){
        //TODO: A random starting player should be generated
    }

    private void reset(){
        board = new Board();
        randomizePlayers();
    }

    private void undo(){
        board.getPreviouslyChanged().setState(null);
        switchCurrPlayer();
    }

    private void play(int col){
        //TODO: checks for field to place move in and plays the move if legal
    }

    private void switchCurrPlayer(){
        currPlayer = (currPlayer==PlayerID.Player0)? PlayerID.Player1 : PlayerID.Player0;
    }


}
