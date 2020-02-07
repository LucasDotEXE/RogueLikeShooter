package sample.BaseGame.Vieuw;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;
import sample.BaseGame.Model.Config;
import sample.BaseGame.Model.I_DrawAble;
import sample.BaseGame.Model.MapData.BaseMap;

import java.awt.*;
import java.util.ArrayList;

public class BaseGameView implements I_GameRenderer {

    private Stage stage;
    private ResizableCanvas canvas;
    private Scene scene;
    private Graphics2D graphics2D;

    public BaseGameView(Stage stage, int sizeX, int sizeY, String pageTitel, boolean resizeAble ) {
        this.stage = stage;

        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(e -> {
        graphics2D = new FXGraphics2D(canvas.getGraphicsContext2D());
        } , mainPane);
        canvas.setFocusTraversable(true);
        mainPane.setCenter(canvas);

        this.scene = new Scene(mainPane, sizeX, sizeY);
        stage.setScene(scene);
        stage.setTitle(pageTitel);
        stage.show();
        stage.setResizable(resizeAble);
    }

    public void render(ArrayList<I_DrawAble> gameModels, BaseMap map) {
        clearScreen();
        drawGameMap(map);
        gameModels.forEach(this::drawGameObject);
    }

    public void drawGameObject(I_DrawAble gameObject) {
        this.graphics2D.setColor(gameObject.getColor());
        gameObject.getModel().forEach(shape -> {
            this.graphics2D.fill(shape);
        });

    }

    private void drawGameMap(BaseMap map) {
        this.graphics2D.setColor(new Color(97, 62, 49));
        this.graphics2D.fill(new Rectangle(0,0, 2000, 2000));
        this.graphics2D.drawImage(map.getBufferedImage(), 0, 0, null);
//        this.canvas.;

//        this.canvas.getGraphicsContext2D().drawImage(map.getFloor(), 5, 5, Config.screenSize.getX(), Config.screenSize.getY());
//        this.canvas.getGraphicsContext2D().drawImage(new Image("simple_door.png"), Config.screenSize.getX()/2 - 54, -30, 104,104);
    }

    private void clearScreen() {
        this.graphics2D.clearRect(0,0,2000,2000);
        this.graphics2D.setColor(Color.WHITE);
    }

    public ResizableCanvas getCanvas() {
        return canvas;
    }
}
