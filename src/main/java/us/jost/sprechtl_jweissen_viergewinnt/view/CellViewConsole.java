package us.jost.sprechtl_jweissen_viergewinnt.view;

import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;

import java.util.HashMap;

public class CellViewConsole implements CellView {
    private HashMap<PlayerID, Character> symbols;

    public CellViewConsole(HashMap<PlayerID, Character> symbols) {
        this.symbols = symbols;
    }

    @Override
    public void display(PlayerID cell) {
        char chrToDisplay;
        if (cell != null) {
            chrToDisplay = symbols.get(cell);
        } else {
            chrToDisplay = ' ';
        }
        System.out.printf("[%c]", chrToDisplay);
    }
}
