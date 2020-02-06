package sample.BaseGame.Model.PlayerData;

import sample.BaseGame.Model.I_GameObject;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

class BaseGun implements I_GameObject {

    // TODO: 1/31/2020 replace with a bullet factory
    private double bulletPerSecond;
    private double cooldown = 0;

    private Point2D.Double position;
    private double rotation;
    private double size;

    ArrayList<BaseBullet> bullets = new ArrayList<>();

    public BaseGun(Point2D.Double position, double rotation, double size) {
        this.position = position;
        this.rotation = rotation;
        this.size = size;
        this.bulletPerSecond = 4;
    }

    public void shoot(Point2D pos) {
        if (cooldown <= 0) {
            bullets.add(new BaseBullet(pos, 10));
            this.cooldown = 1/bulletPerSecond;
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

        Shape gun = pos.createTransformedShape(af.createTransformedShape(new Rectangle2D.Double(this.size/3, this.size/2, this.size/3, this.size)));

        shapes.add(gun );
        return shapes;
    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    @Override
    public void update(double deltaTime) {
        this.cooldown -= deltaTime;
//        System.out.println(cooldown);
        if (cooldown < 0){
            this.cooldown = 0;
        }
    }

    public void setPosition(Point2D.Double position) {
        this.position = position;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
}