package io.github.gleidsonmt.dashboardfx.presentation.presentations.controls;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  02/04/2025
 */
public class CheckBoxPres extends StackPane {

    public CheckBoxPres() {
        getChildren().setAll(
                new Tutorial()
                        .h3("CheckBox")
                        .text("""
                                A tri-state selection Control typically skinned as a box with a checkmark or tick mark when checked.""")
                        .legend("javafx.scene.control.CheckBox")
                        .demo(createDemo("Select me"))
                        .code("CheckBox checkBox = new CheckBox(\"Select me\");")
                        .h4("List", "CheckBox")
                        .demo(
                                createList(
                                        createDemo("Drink coffee"),
                                        createDemo("List music"),
                                        createDemo("Close the window")
                                )
                        )
                        .build()
                        .getRoot()
        );
    }

    public VBox createList(CheckBox... checkBoxes) {
        VBox box = new VBox();
        box.getChildren().addAll(checkBoxes);
        box.setSpacing(5);
        return box;
    }

    public CheckBox createDemo(String text) {
        CheckBox container = new CheckBox(text);
        container.setIndeterminate(true);
        container.setAllowIndeterminate(true);
        return container;
    }
}
