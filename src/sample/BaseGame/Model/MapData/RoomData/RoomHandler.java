package sample.BaseGame.Model.MapData.RoomData;

import java.util.ArrayList;

public class RoomHandler {

    private ArrayList<BaseRoom> rooms;
    private BaseRoom currentRoom;

    public RoomHandler() {
        this.rooms = new ArrayList<>();
        this.currentRoom = getStartRoom();
    }

    private BaseRoom getStartRoom() {
        return new BaseRoom();
    }
}
