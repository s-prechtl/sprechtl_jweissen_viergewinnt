package us.jost.sprechtl_jweissen_viergewinnt.view;

import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;

import java.util.ArrayList;
import java.util.HashMap;

public class BoardViewConsole implements BoardView {
    private CellViewConsole cellView;

    public BoardViewConsole(HashMap<PlayerID, Character> symbols) {
        cellView = new CellViewConsole(symbols);
    }

    /**
     * Displays the board using CellViewConsole with column numbers on top
     * @param board
     */
    @Override
    public void display(ArrayList<ArrayList<PlayerID>> board) {
        for (int i = 0; i < board.size(); i++) {
            System.out.printf(" %d ", i);
        }
        System.out.println();
        for (int row = board.get(0).size()-1; row >= 0; row--) {
            for (ArrayList<PlayerID> col : board) {
                cellView.display(col.get(row));
            }
            System.out.println();
        }
    }
}
