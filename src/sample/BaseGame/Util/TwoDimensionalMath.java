package sample.BaseGame.Util;

import java.awt.geom.Point2D;

public class TwoDimensionalMath {

    public static double angleOf(Point2D target, Point2D mouse) {

        if (mouse != null) {
            Point2D diff = new Point2D.Double(mouse.getX() - target.getX(), mouse.getY() - target.getY());
            double targetAngle = Math.atan2(diff.getY(), diff.getX()) - Math.PI/2;

            while (targetAngle > Math.PI)
                targetAngle -= 2 * Math.PI;

            while (targetAngle < -Math.PI)
                targetAngle += 2 * Math.PI;

            return targetAngle;
        } else {
            return Math.atan2(target.getX(), target.getY()) - Math.PI/2;
        }
    }
}
