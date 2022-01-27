package us.jost.sprechtl_jweissen_viergewinnt.model;

public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public static String input(){
        //TODO: gets an input to place cell
        return "";
    }

    public String getName() {
        return name;
    }
}
