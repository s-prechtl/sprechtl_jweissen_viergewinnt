package us.jost.sprechtl_jweissen_viergewinnt.view;

import java.util.ArrayList;
import java.util.HashMap;

public class BoardViewConsole implements BoardView {
    private CellViewConsole cellView;

    BoardViewConsole(HashMap<PlayerID, Character> symbols) {

    }

    @Override
    public void display(ArrayList<ArrayList<PlayerID>> board) {
        //TODO: display board using CellView
    }
}
