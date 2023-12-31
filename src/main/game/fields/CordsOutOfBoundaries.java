package main.game.fields;

public class CordsOutOfBoundaries extends Exception{
    public CordsOutOfBoundaries(){
        super("Cords must be in 0-3 range");
    }

    public CordsOutOfBoundaries(String mess){
        super(mess);
    }
}
