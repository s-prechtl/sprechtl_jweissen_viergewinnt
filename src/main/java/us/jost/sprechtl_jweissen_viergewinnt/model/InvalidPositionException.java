package us.jost.sprechtl_jweissen_viergewinnt.model;

public class InvalidPositionException extends Exception{
    public InvalidPositionException() {
        super("This postion isn't valid!");
    }
}
