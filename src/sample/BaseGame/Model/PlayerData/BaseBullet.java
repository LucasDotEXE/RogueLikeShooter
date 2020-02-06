package sample.BaseGame.Model.PlayerData;

import sample.BaseGame.BaseGameWrapper;
import sample.BaseGame.Model.Config;
import sample.BaseGame.Model.I_GameObject;
import sample.BaseGame.Util.TwoDimensionalMath;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class BaseBullet implements I_GameObject {
    private Point2D position;
    private Boolean hit = false;
    private double size;
    private double rotation;

    public BaseBullet(Point2D position) {
        this(position, 20);
    }

    public BaseBullet(Point2D position, double size) {
        this.position = position;
        this.size = size;
        this.rotation = TwoDimensionalMath.angleOf(this.position, BaseGameWrapper.getBaseGameController().getMousePos()) + (Math.PI * 0.5);
    }

    @Override
    public void update(double deltatime) {
        if (true) {// TODO: 2/6/2020 Detect hit
            this.position = new Point2D.Double(
                    this.position.getX() + (Math.cos(this.rotation)  * deltatime) * Config.UNIVERSAL_SPEED_MODIFIER,
                    this.position.getY() + (Math.sin(this.rotation) * deltatime) * Config.UNIVERSAL_SPEED_MODIFIER);
        }
    }



    @Override
    public ArrayList<Shape> getModel() {
        ArrayList<Shape> shapes = new ArrayList<>();
        AffineTransform af = new AffineTransform();
        AffineTransform pos = new AffineTransform();

        af.translate(0, 0);
        af.rotate(this.rotation);
        af.translate(-size/2, -size/2);

        pos.translate(this.position.getX(), this.position.getY());
//        System.out.println(rotation);
        Shape bullet = pos.createTransformedShape(af.createTransformedShape(new Rectangle2D.Double(0, 0, this.size, this.size)));
        shapes.add(bullet);
        return shapes;
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

}
