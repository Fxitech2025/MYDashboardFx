package io.github.gleidsonmt.dashboardfx.presentation.presentations.controls;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import io.github.gleidsonmt.glad.controls.toggle_switch.ToggleSwitch;
import io.github.gleidsonmt.presentation.Row;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  21/03/2025
 */
public class ToggleSwitchPres extends StackPane {
    public ToggleSwitchPres() {
        getChildren().setAll(
                new Tutorial()
                        .h3("Toggle Switch")
                        .text("""
                                 A toggle specialized in turning off and on action.""")
                        .legend("io.github.gleidsonmt.glad.controls.toggle_switch.ToggleSwitch")
                        .h4("Demo", "Toggle Switch")
                        .demo(
                                new ToggleSwitch()
                        )
                        .code("""
                                    // Constructors
                                    ToggleSwitch toggleSwitch = new ToggleSwitch();
                                    // Set on
                                    toggleSwitch.setOn(true);
                                    """)

                        .table(
                                new Row("-fx-color-animation", "-fx-accent"),
                                new Row("-fx-track-color", "-fx-background")
                        )
                        .code("""
                                .toggle-switch {
                                    -fx-color-animation: fx-accent;
                                    -fx-track-color: -fx-background;
                                }
                                """)

                        .build()
                        .getRoot()
        );
    }

}
