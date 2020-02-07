package sample.BaseGame.Util;

import javafx.scene.transform.Rotate;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageManipulation {

    public static BufferedImage rotateClockwise90(BufferedImage src) {
        int width = src.getWidth();
        int height = src.getHeight();

        BufferedImage dest = new BufferedImage(height, width, src.getType());

        Graphics2D graphics2D = dest.createGraphics();
        graphics2D.translate((height - width) / 2, (height - width) / 2);
        graphics2D.rotate(Math.PI / 2, height / 2, width / 2);
        graphics2D.drawRenderedImage(src, null);

        return dest;
    }

//    public static BufferedImage rotate90(BufferedImage src) {
//        Rotate rotate = new Rotate(90);
//        BufferedImage rotatedImg = rotate.;
//    }

        public static BufferedImage rotateClockwise180(BufferedImage src) {
        int width = src.getWidth();
        int height = src.getHeight();

        BufferedImage dest = new BufferedImage(height, width, src.getType());

        Graphics2D graphics2D = dest.createGraphics();
        graphics2D.translate((height - width) / 2, (height - width) / 2);
        graphics2D.rotate(Math.PI, height / 2, width / 2);
        graphics2D.drawRenderedImage(src, null);

        return dest;
    }

        public static BufferedImage rotateClockwise270(BufferedImage src) {
        int width = src.getWidth();
        int height = src.getHeight();

        BufferedImage dest = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics2D = dest.createGraphics();
        graphics2D.translate((height - width) / 2, (height - width) / 2);
        graphics2D.rotate(3*Math.PI / 2, height / 2, width / 2);
        graphics2D.drawRenderedImage(src, null);

        return dest;
    }

    public static BufferedImage rotateClockwise90New(BufferedImage src) {
        int w = src.getWidth();
        int h = src.getHeight();
        BufferedImage dest = new BufferedImage(h, w, src.getType());
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++)
                dest.setRGB(y, w - x - 1, src.getRGB(x, y));
        return dest;
    }




}
