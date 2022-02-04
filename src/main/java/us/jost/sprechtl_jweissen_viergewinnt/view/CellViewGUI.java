package us.jost.sprechtl_jweissen_viergewinnt.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;

import java.util.HashMap;

public class CellViewGUI {
    HashMap<PlayerID, Color> colors;

    public CellViewGUI(HashMap<PlayerID, Color> colors) {
        this.colors = colors;
    }

    public void display(Circle cell, PlayerID playerID) {
        cell.setFill(colors.get(playerID));
    }
}
