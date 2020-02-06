package sample.BaseGame.Model;

import sample.BaseGame.Model.MapData.BaseMap;
import sample.BaseGame.Model.PlayerData.BasePlayer;

import java.util.ArrayList;

public class BaseGameModel {

    private BasePlayer player;
    private BaseMap map;


    public BaseGameModel() {
        this.player = new BasePlayer(25, 1.5);
        this.map = new BaseMap();
    }

    public ArrayList<I_DrawAble> getAllGameModdels() {
        ArrayList<I_DrawAble> gameObjects = new ArrayList<>();

        gameObjects.addAll(player.getAllGameObjects());
        return gameObjects;
    }

    public void update(double deltatime) {
        map.update(deltatime);
        player.getAllGameObjects().forEach(i_gameObject -> i_gameObject.update(deltatime));
    }

    public BasePlayer getPlayer() {
        return player;
    }

    public BaseMap getMap() {
        return map;
    }
}
