package us.jost.sprechtl_jweissen_viergewinnt.model;

public class UndoNotPossibleException extends Exception{
    public UndoNotPossibleException() {
        super("Undo not possible at the moment. Do another move first!");
    }
}
