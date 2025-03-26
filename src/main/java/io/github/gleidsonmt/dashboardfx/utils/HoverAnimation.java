package io.github.gleidsonmt.dashboardfx.utils;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  25/03/2025
 */
public class HoverAnimation {

    public static void install(Node node) {
        node.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            node.setScaleX(0.9);
            node.setScaleY(0.9);
        });

        node.addEventFilter(MouseEvent.MOUSE_RELEASED, event -> {
            node.setScaleX(1.0);
            node.setScaleY(1.0);
        });

        node.addEventFilter(MouseEvent.MOUSE_MOVED, event -> {
            node.setScaleX(1.05);
            node.setScaleY(1.05);
        });

        node.addEventFilter(MouseEvent.MOUSE_MOVED, event -> {
            node.setScaleX(1.05);
            node.setScaleY(1.05);
        });

        node.addEventFilter(MouseEvent.MOUSE_EXITED, event -> {
            node.setScaleX(1.0);
            node.setScaleY(1.0);
        });

    }
}
