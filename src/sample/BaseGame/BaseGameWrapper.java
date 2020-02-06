package sample.BaseGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import sample.BaseGame.Controller.BaseGameInput;
import sample.BaseGame.Model.BaseGameModel;
import sample.BaseGame.Model.Config;
import sample.BaseGame.Model.I_DrawAble;
import sample.BaseGame.Vieuw.BaseGameView;

import java.util.ArrayList;

public class BaseGameWrapper extends Application {


    private static BaseGameView baseGameView;           //View
    private static BaseGameModel baseGameModel;         //Model
    private static BaseGameInput baseGameController;         //Controller

    public static BaseGameModel getBaseGameModel() {
        return baseGameModel;
    }

    public static BaseGameView getBaseGameView() {
        return baseGameView;
    }

    public static BaseGameInput getBaseGameController() {
        return baseGameController;
    }


    @Override
    public void start(Stage stage) {

        baseGameModel = new BaseGameModel();
        baseGameView = new BaseGameView(stage, (int) Config.screenSize.getX(), (int) Config.screenSize.getY(), "Make Your Gun", false);
        baseGameController = new BaseGameInput();

        new AnimationTimer() {
            long last = -1;

            @Override
            public void handle(long now) {
                if (last == -1)
                    last = now;
                baseGameModel.update((now - last) / Config.BASE_GAME_CLOCKSPEED);

                last = now;
                baseGameView.render(baseGameModel.getAllGameModdels(), baseGameModel.getMap());
            }
        }.start();
    }
}
