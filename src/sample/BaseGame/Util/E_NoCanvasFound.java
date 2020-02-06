package sample.BaseGame.Util;

public class E_NoCanvasFound extends Exception{

    public E_NoCanvasFound() {}

    // Constructor that accepts a message
    public E_NoCanvasFound(String message)
    {
        super(message);
    }
}
