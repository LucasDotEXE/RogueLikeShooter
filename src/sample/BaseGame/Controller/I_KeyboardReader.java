package sample.BaseGame.Controller;

import javafx.scene.input.KeyCode;

import java.util.HashSet;

public interface I_KeyboardReader {
    HashSet<KeyCode> getKeys();
}
