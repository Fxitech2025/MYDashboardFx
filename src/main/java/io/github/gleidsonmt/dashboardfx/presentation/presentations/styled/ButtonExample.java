package io.github.gleidsonmt.dashboardfx.presentation.presentations.styled;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import javafx.scene.layout.StackPane;


/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  28/04/2025
 */
public class ButtonExample extends StackPane {

    public ButtonExample() {
        getChildren().setAll(
                new Tutorial()
                        .build()
                        .getRoot()
        );
    }
}
