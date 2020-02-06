package sample.BaseGame.Vieuw;

import sample.BaseGame.Model.I_DrawAble;
import sample.BaseGame.Model.MapData.BaseMap;

import java.util.ArrayList;

public interface I_GameRenderer {
    void render(ArrayList<I_DrawAble> gameModels, BaseMap map);
}
