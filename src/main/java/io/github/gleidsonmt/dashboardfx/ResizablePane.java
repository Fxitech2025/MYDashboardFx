package io.github.gleidsonmt.dashboardfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  24/03/2025
 */
@ApiStatus.Experimental
public class ResizablePane extends HBox {
//    public T demo(List<Node> nodes) {
//        this.items.add(this.createDemos(nodes));
//        return (T)this;
//    }
    public ResizablePane(List<Node> nodes) {
        for (Node node: nodes) {
            HBox.setHgrow(node, Priority.ALWAYS);
        }
        configLayout();

        getChildren().addAll(nodes);
        getChildren().add(createBar());
    }

    public ResizablePane(Node... content) {
        for (Node node: content) {
            HBox.setHgrow(node, Priority.ALWAYS);
        }

        configLayout();

        getChildren().addAll(content);
        getChildren().add(createBar());
    }

    private Node createBar() {
        Pane bar = new Pane();
        bar.setMinSize(5, 20);
        bar.setMaxSize(5, 30);
        bar.getStyleClass().addAll("bg-medium-gray-2", "radius-5");
        bar.setCursor(Cursor.W_RESIZE);

        bar.setOnMouseDragged(e -> {
            VBox box = (VBox) getParent();
            Bounds bounds = box.sceneToLocal(box.getLayoutBounds());
            setMaxWidth((e.getSceneX() + bounds.getMaxX()) - box.getWidth());
        });
        return bar;
    }

    private void configLayout() {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        getStyleClass().addAll("border-2", "border-light-gray-2", "padding-5", "radius-5");
    }
}
