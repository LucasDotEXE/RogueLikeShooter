package sample.BaseGame.Model.PlayerData;

import javafx.scene.input.KeyCode;
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

public class BasePlayer implements I_GameObject {

    private double diameter;
    private double speed;

    private Point2D.Double position;
    private double rotation;

    private BaseGun gun;


    public BasePlayer(double diameter, double speed) {

        this.position = new Point2D.Double(Config.screenSize.getX()/2, Config.screenSize.getY()/2);
        this.diameter = diameter;
        this.speed    = speed;
        this.rotation = TwoDimensionalMath.angleOf(this.position, this.position);
        this.gun = new BaseGun(this.position, this.rotation, diameter);
    }

    @Override
    public ArrayList<Shape> getModel() {
        ArrayList<Shape> shapes = new ArrayList<>();
        AffineTransform af = new AffineTransform();
        AffineTransform pos = new AffineTransform();

        af.translate(0, 0);
        af.rotate(this.getRotation());
        af.translate(-diameter/2, -diameter/2);

        pos.translate(this.position.getX(), this.position.getY());
//        System.out.println(position);
        Shape player = pos.createTransformedShape(af.createTransformedShape(new Ellipse2D.Double(0, 0, this.diameter, this.diameter)));
//        Shape gun = pos.createTransformedShape(af.createTransformedShape(new Rectangle2D.Double(this.diameter/3, this.diameter/2, this.diameter/3, this.diameter)));
        shapes.add(player);
        return shapes;
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    @Override
    public void update(double deltaTime) {
        BaseGameWrapper.getBaseGameController().getKeys().forEach(keyCode -> {
            moveInDirection(keyCode, deltaTime);
        });
        this.rotation = TwoDimensionalMath.angleOf(this.position, BaseGameWrapper.getBaseGameController().getMousePos());
        this.gun.setPosition(this.position);
        this.gun.setRotation(this.rotation);
    }



    public void shoot() {
        this.gun.shoot(this.position);
    }



    private void moveInDirection(KeyCode direction, double deltatime) {
        if (direction == KeyCode.D && this.position.getX() < Config.screenSize.getX()-55) {
            setPosition((int) this.position.getX() + (int) (this.speed* (deltatime * Config.UNIVERSAL_SPEED_MODIFIER)), (int) this.position.getY());
        } else if (direction == KeyCode.A && this.position.getX() > 65) {
            setPosition((int) this.position.getX() - (int) (this.speed * (deltatime * Config.UNIVERSAL_SPEED_MODIFIER)), (int) this.position.getY());
        } else  if (direction == KeyCode.W && this.position.getY() > 75){
            setPosition((int) this.position.getX(), (int) this.position.getY() - (int)(this.speed*(deltatime * Config.UNIVERSAL_SPEED_MODIFIER)));
        } else  if (direction == KeyCode.S && this.position.getY() < Config.screenSize.getY()-65) {
            setPosition((int) this.position.getX(), (int) this.position.getY() + (int) (this.speed * (deltatime * Config.UNIVERSAL_SPEED_MODIFIER)));
        } else if(direction == KeyCode.SPACE ){
            this.shoot();
        } else setPosition((int) this.position.getX(), (int) this.position.getY());
    }

    public void setPosition(int x, int y) {

        this.position.setLocation(x, y);
    }

    public Point2D.Double getPosition() {
        return position;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public BaseGun getGun() {
        return gun;
    }

    public ArrayList<I_GameObject> getAllGameObjects() {
        ArrayList<I_GameObject> gameObjects = new ArrayList<>();
        gameObjects.addAll(this.gun.bullets);
        gameObjects.add(this.gun);
        gameObjects.add(this);
        return gameObjects;
    }
}
