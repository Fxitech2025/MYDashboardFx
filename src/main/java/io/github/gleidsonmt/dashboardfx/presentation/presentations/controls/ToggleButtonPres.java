package io.github.gleidsonmt.dashboardfx.presentation.presentations.controls;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  21/03/2025
 */
public class ToggleButtonPres extends StackPane {
    public ToggleButtonPres() {
        getChildren().setAll(
                new Tutorial()
                        .h3("Toggle Button")
                        .demo(
                                new ToggleButton("Toggle"),
                                new ToggleButton("Toggle")
                        )
                        .build()
                        .getRoot()
        );
    }
}
