package io.github.gleidsonmt.dashboardfx.presentation.presentations.components;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  10/04/2025
 */
public class ButtonExample extends StackPane {

    public ButtonExample() {
        new Group();
        getChildren().setAll(
                new Tutorial()
                        .h3("Style")
                        .text("Button style examples.")
                        .h3("Flat", "Button")
                        .demo(createButtonDemo("Button", new SVGIcon(Icon.HOME), "flat"))
                        .code("""
                                btn.getStyleClass().addAll("flat");
                                """)
                        .demo(
                                createButtonDemo("Round Button", new SVGIcon(Icon.ADD), "size-50", "round", "display-graphic", "raised")
                        )
                        .code("""
                                // Floating button
                                Button btn = new Button(text);
                                btn.setGraphic(new SVGIcon(Icon.ADD));
                                btn.getStyleClass().addAll("size-50", "round", "display-graphic", "raised");
                                """)
                        .build()
                        .getRoot()
        );
    }

    private Node createButtonDemo(String... classes) {
        return createButtonDemo("Button", false, false, classes);
    }

    private Button createButtonDemo(String text, String... classes) {
        return createButtonDemo(text, false, false, classes);
    }

    private Button createButtonDemo(String text, boolean _default, String... classes) {
        return createButtonDemo(text, _default, false, classes);
    }

    private Button createButtonDemo(String text, Node graphic, String... classes) {
        Button button = createButtonDemo(text, classes);
        button.setGraphic(graphic);
        return button;
    }

    private Button createButtonDemo(String text, boolean _default, boolean _cancel, String... classes) {
        Button btn = new Button(text);
        btn.setDefaultButton(_default);
        btn.setCancelButton(_cancel);
        btn.getStyleClass().addAll(classes);
        return btn;
    }
}
