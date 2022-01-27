package us.jost.sprechtl_jweissen_viergewinnt.view;


import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;

import java.util.ArrayList;

public interface BoardView {
    void display(ArrayList<ArrayList<PlayerID>> board);
}
