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
                               Text input component that allows a user to enter a single line of unformatted text.""")
                        .legend("javafx.scene.control.TextField")
                        .text("All classes in (Text) works in the text inside button.")
                        .text("All classes in (Region) can by apply.")

                        .h4("Demo", "Text Field")
                        .demo(
                                new TextField("Placeholder")
                        )
                        .code("Button button = new Button(\"Button\");")
                        .h4("Install", "Text Field")
                        .code("ThemeProvider.install(scene, ... \n\tCss.TEXT_FIELD);", "java")





                        .build()
                        .getRoot()
        );
    }

}
