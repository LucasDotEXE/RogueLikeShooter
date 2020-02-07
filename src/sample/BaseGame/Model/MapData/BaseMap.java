package sample.BaseGame.Model.MapData;

import javafx.scene.image.Image;
import sample.BaseGame.Model.Config;
import sample.BaseGame.Model.I_UpdateAble;
import sample.BaseGame.Model.MapData.RoomData.BaseRoom;
import sample.BaseGame.Model.MapData.RoomData.RoomHandler;
import sample.BaseGame.Util.ImageManipulation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BaseMap implements I_UpdateAble {

    private Image floor;

    private BufferedImage bufferedImage;

    private RoomHandler roomHandler;

    public BaseMap() {
        this.floor = new Image("empty_room.png");
        this.roomHandler = new RoomHandler();

        this.bufferedImage = new BufferedImage(2000,2000, BufferedImage.TYPE_INT_ARGB);
        drawCashe();

    }

    private void drawCashe() {
        Graphics2D graphics2D = this.bufferedImage.createGraphics();
        try {
            BufferedImage doorU = ImageIO.read(new File("rec/doors/simple_door_u.png"));
            BufferedImage doorR = ImageIO.read(new File("rec/doors/simple_door_r.png"));
            BufferedImage doorD = ImageIO.read(new File("rec/doors/simple_door_d.png"));
            BufferedImage doorL = ImageIO.read(new File("rec/doors/simple_door_l.png"));
            graphics2D.drawImage(ImageIO.read(new File("rec/empty_room.png")), 5, 5, (int) Config.screenSize.getX(), (int) Config.screenSize.getY(), null);
            graphics2D.drawImage(doorU, (int)(Config.screenSize.getX())/2 - 54, -30, 104,104, null);
            graphics2D.drawImage(doorR, (int)(Config.screenSize.getX()-54), (int)(Config.screenSize.getY()/2)-54, 104,104, null);
            graphics2D.drawImage(doorD, (int)(Config.screenSize.getX())/2 - 54, (int)Config.screenSize.getY()-54, 104,104, null);
            graphics2D.drawImage(doorL, -35, (int)(Config.screenSize.getY()/2-54), 104,104, null);

//            graphics2D.drawImage(ImageManipulation.rotateClockwise180(door), (int)(Config.screenSize.getX())/2 - 54, -30, 104,104, null);
//            graphics2D.drawImage(ImageManipulation.rotateClockwise270(door), (int)(Config.screenSize.getX())/2 - 54, -30, 104,104, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public Image getFloor() {
        return floor;
    }

    @Override
    public void update(double deltaTime) {

    }
}
