package us.jost.sprechtl_jweissen_viergewinnt.view;

import java.util.HashMap;

public class CellViewConsole implements CellView {
    private HashMap<PlayerID, Character> symbols;

    public CellViewConsole(HashMap<PlayerID, Character> symbols) {

    }

    @Override
    public void display(PlayerID cell) {
        //TODO: display the cell using symbols hashmap
    }
}
