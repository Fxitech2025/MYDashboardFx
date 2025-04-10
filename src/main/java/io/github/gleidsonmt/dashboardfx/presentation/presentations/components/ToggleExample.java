package io.github.gleidsonmt.dashboardfx.presentation.presentations.components;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  10/04/2025
 */
public class ToggleExample extends StackPane {

    public ToggleExample() {
        getChildren().setAll(
                new Tutorial()
                        .h3("Toggle")
                        .text("Toggle style examples.")
                        .demo(createSimple())
                        .code("""
                                ToggleGroup group = new ToggleGroup();
                                ToggleButton left = new ToggleButton("Left");
                                ToggleButton middle = new ToggleButton("Middle");
                                ToggleButton right = new ToggleButton("Right");
                                left.getStyleClass().addAll("pill-left");
                                right.getStyleClass().addAll("pill-right");
                                middle.getStyleClass().addAll("radius-0");
                                group.getToggles().addAll(left, middle, right);""")
                        .build()
                        .getRoot()
        );
    }

    private Node createSimple() {
        ToggleGroup group = new ToggleGroup();
        ToggleButton left = new ToggleButton("Left");
        ToggleButton middle = new ToggleButton("Middle");
        ToggleButton right = new ToggleButton("Right");
        left.getStyleClass().addAll("pill-left");
        right.getStyleClass().addAll("pill-right");
        middle.getStyleClass().addAll("radius-0");
        group.getToggles().addAll(left, middle, right);
        return new HBox(left, middle, right);
    }
}
