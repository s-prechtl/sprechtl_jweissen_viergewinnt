package us.jost.sprechtl_jweissen_viergewinnt.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;

import java.util.ArrayList;
import java.util.HashMap;

public class BoardViewGUI {
    ArrayList<ArrayList<Circle>> board;
    CellViewGUI cellViewGUI;

    BoardViewGUI(ArrayList<ArrayList<Circle>> board, HashMap<PlayerID, Color> colors) {
        this.board = board;
        cellViewGUI = new CellViewGUI(colors);
    }

    public void updateCell(int x, int y, PlayerID playerID) {
        cellViewGUI.display(board.get(x).get(y), playerID);
    }
}
