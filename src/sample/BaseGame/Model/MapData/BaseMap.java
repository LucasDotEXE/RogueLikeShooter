package sample.BaseGame.Model.MapData;

import javafx.scene.image.Image;
import sample.BaseGame.Model.I_UpdateAble;
import sample.BaseGame.Model.MapData.RoomData.BaseRoom;

import java.util.ArrayList;

public class BaseMap implements I_UpdateAble {

    private Image floor;

    ArrayList<BaseRoom> rooms;

    public BaseMap() {
        this.floor = new Image("empty_room.png");

    }

    public Image getFloor() {
        return floor;
    }

    @Override
    public void update(double deltaTime) {

    }
}
