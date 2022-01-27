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

    public boolean checkWin(){
        //TODO: checks for a win starting at previouslyChanged
        return false;
    }

    public boolean checkTie(){
        boolean isTie = true;
        for (int x = 0; x < COLS && isTie; x++) {
            for (int y = 0; y < ROWS && isTie; y++) {
                if (accessCell(x,y).getState() == null){
                    isTie = false;
                }
            }
        }
        return isTie;
    }

    private static boolean inArea(int x, int y){
        return (x < COLS) && (x >= 0) && (y < ROWS) && (y >= 0);
    }

    public ArrayList<ArrayList<PlayerID>> boardToPlayerIDs(){
        //TODO: converts the board to primitive datatypes using PlayerID enums
        return new ArrayList<>();
    }

    private int getNextFreeRow(int col){
        int nextFreeRow = -1;

        for (int y = 0; y < ROWS && nextFreeRow == -1; y++) {
            if (accessCell(col, y).getState() == null){
                nextFreeRow = y;
            }
        }

        return nextFreeRow;
    }

    private Cell accessCell(int x, int y){
        Cell cell;
        if (inArea(x, y)){
            cell = board.get(x).get(y);
        }else {
            //TODO: errorHandling
            cell = new Cell();
        }
        return cell;
    }

    public Cell getPreviouslyChanged() {
        return previouslyChanged;
    }
}
