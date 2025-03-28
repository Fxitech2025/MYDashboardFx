package io.github.gleidsonmt.dashboardfx.presentation.presentations.controls;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  21/03/2025
 */
public class TextFieldPres extends StackPane {
    public TextFieldPres() {
        getChildren().setAll(
                new Tutorial()
                        .h3("Text Field")
                        .text("""
                                 ToggleButton is a specialized control which has the ability to be selected.
                                 Typically a ToggleButton is rendered similarly to a Button. 
                                 However, they are two different types of Controls. 
                                 A Button is a "command" button which invokes a function when clicked.""")
                        .legend("javafx.scene.control.ToggleButton")
                        .text("All classes in (Text) works in the text inside button.")
                        .text("All classes in (Region, Label, Button) can by apply.")
                        .demo(
                                new TextField("Placeholder")
                        )
                        .code("""
                                ToggleButton btn = new ToggleButton("Button");
                                """)


                        .h4("Toggle Group", "Toggle Button")
                        .text(""" 
                                A class which contains a reference to all Toggles whose selected variables should be managed such that only a single Toggle within the ToggleGroup may be selected at any one time.
                                Generally ToggleGroups are managed automatically simply by specifying the name of a ToggleGroup on the Toggle, but in some situations it is desirable to explicitly manage which ToggleGroup is used by Toggles.""")
                        .legend("javafx.scene.control.ToggleGroup")
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
