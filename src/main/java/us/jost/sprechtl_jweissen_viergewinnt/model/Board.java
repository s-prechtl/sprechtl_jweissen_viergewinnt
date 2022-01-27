package us.jost.sprechtl_jweissen_viergewinnt.model;

import java.util.ArrayList;

public class Board {
    private final ArrayList<ArrayList<Cell>> board = new ArrayList<>();
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private Cell previouslyChanged;

    public Board() {
        for (int x = 0; x < COLS; x++) {
            board.add(new ArrayList<>());
            for (int y = 0; y < ROWS; y++) {
                board.get(x).add(new Cell());
            }
        }
        previouslyChanged = null;
    }

    public void clear(){
        //TODO: clears all cells
    }

    public boolean checkWin(){
        //TODO: checks for a win starting at previouslyChanged
        return false;
    }

    public boolean checkTie(){
        //TODO: checks for tie
        return false;
    }

    private static boolean inArea(int x, int y){
        //TODO: checks if xy is in ROWSCOLS
        return false;
    }

    public ArrayList<ArrayList<PlayerID>> boardToPlayerIDs(){
        //TODO: converts the board to primitive datatypes using PlayerID enums
        return new ArrayList<>();
    }

    private boolean isLegalMove(int col){
        //TODO: checks if called col is not filled
        return false;
    }

    private Cell accessCell(int x, int y){
        //TODO: board.get().get() mit if inArea().
        return new Cell();
    }

    public Cell getPreviouslyChanged() {
        return previouslyChanged;
    }
}
