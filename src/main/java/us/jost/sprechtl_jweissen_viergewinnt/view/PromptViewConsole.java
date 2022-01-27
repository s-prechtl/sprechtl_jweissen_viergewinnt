package us.jost.sprechtl_jweissen_viergewinnt.view;

import java.util.Scanner;

public class PromptViewConsole implements PromptView {
    @Override
    public void display(String playerName, String msg) {
        System.out.println("[" + playerName + "] " + msg);
    }
}
