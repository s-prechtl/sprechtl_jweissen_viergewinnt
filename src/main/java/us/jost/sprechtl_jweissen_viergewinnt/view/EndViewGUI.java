package us.jost.sprechtl_jweissen_viergewinnt.view;

import javafx.scene.control.Label;

public class EndViewGUI implements EndView {
    Label label;

    public EndViewGUI(Label label) {
        this.label = label;
    }


    @Override
    public void displayWin(String winnerName) {
        label.setText(winnerName + " has won! Congratulations!");
    }

    @Override
    public void displayTie() {
        label.setText("It's a tie!");
    }
}
