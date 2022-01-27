package us.jost.sprechtl_jweissen_viergewinnt.model;

public class Cell {
    private PlayerID state;

    public Cell() {
        state = null;
    }

    public PlayerID getState() {
        return state;
    }

    public void setState(PlayerID state) {
        this.state = state;
    }
}
