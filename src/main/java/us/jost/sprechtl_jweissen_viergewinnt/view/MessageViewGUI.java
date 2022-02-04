package us.jost.sprechtl_jweissen_viergewinnt.view;

import javafx.scene.control.Label;

public class MessageViewGUI implements MessageView {
    Label label;

    public MessageViewGUI(Label label) {
        this.label = label;
    }

    @Override
    public void display(String msg) {
        label.setText(msg);
    }
}
