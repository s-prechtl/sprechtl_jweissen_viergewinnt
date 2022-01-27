package us.jost.sprechtl_jweissen_viergewinnt.view;

public class MessageViewConsole implements MessageView {
    @Override
    public void display(String msg) {
        System.out.println(msg);
    }
}
