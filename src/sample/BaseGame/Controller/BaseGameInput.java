package sample.BaseGame.Controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sample.BaseGame.BaseGameWrapper;
import sample.BaseGame.Util.E_NoCanvasFound;

import java.awt.geom.Point2D;
import java.util.HashSet;

public class BaseGameInput implements I_InputReader {

    // Set of currently heldDownKeys keys
    private HashSet<KeyCode> heldDownKeys;
    private Point2D.Double mousePosition;

    public BaseGameInput() {
        this.heldDownKeys  = new HashSet<>();
        this.mousePosition = new Point2D.Double(0, 0);

        try {
            Canvas canvas = getCanvas();

            canvas.setOnKeyPressed  (this::keyPressed);
            canvas.setOnKeyReleased (this::keyReleased);
            canvas.setOnMouseMoved  (this::mouseMoved);
            canvas.setOnMouseClicked(this::shoot);
        } catch (NullPointerException nullPointer) {
            System.out.println("                                 ERROR\n" +
                    "#########################################################################################\n" +
                    "When initialising the Input reader the Canvas from the BaseGameView returned Null\n" +
                    "This could be because you haven't initialised the BaseGameView before the BaseGameInput\n" +
                    "#########################################################################################\n");

            nullPointer.printStackTrace();

            System.out.println("\n\nNow Closing Application");
            System.exit(-1);
        }
    }

    private Canvas getCanvas() throws NullPointerException{
        return BaseGameWrapper.getBaseGameView().getCanvas();
    }

    @Override
    public HashSet<KeyCode> getKeys() {
        return this.heldDownKeys;
    }

    @Override
    public Point2D.Double getMousePos() {
        return this.mousePosition;
    }

    private synchronized void keyPressed(KeyEvent e) {
        this.heldDownKeys.add(e.getCode());
    }

    private synchronized void keyReleased(KeyEvent e) {
        this.heldDownKeys.remove(e.getCode());
    }

    private synchronized void mouseMoved(MouseEvent e) {
        this.mousePosition = new Point2D.Double(e.getX(), e.getY());
    }

    private synchronized void shoot(MouseEvent e) {
        BaseGameWrapper.getBaseGameModel().getPlayer().shoot();
    }

    public HashSet<KeyCode> getHeldDownKeys() {
        return this.heldDownKeys;
    }

}
