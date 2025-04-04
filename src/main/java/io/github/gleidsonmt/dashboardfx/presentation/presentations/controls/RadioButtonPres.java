package io.github.gleidsonmt.dashboardfx.presentation.presentations.controls;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  02/04/2025
 */
public class RadioButtonPres extends StackPane {

    public RadioButtonPres() {

        getChildren().setAll(
                new Tutorial()
                        .h3("Radio Button")
                        .text("""
                                RadioButtons create a series of items where only one item can be selected. RadioButtons are a specialized ToggleButton.""")
                        .legend("javafx.scene.control.RadioButton")
                        .demo(createDemo("Select me"))
                        .code("""
                                RadioButton radioButton = new RadioButton("Select");
                                """)
                        .h4("Toggle Group", "Radio Button")
                        .text("Select only one using Toggle Group")
                        .demo(
                                createGroup(
                                        createDemo("Daily"),
                                        createDemo("Weekly"),
                                        createDemo("Yearly")
                                )
                        )
                        .code("""
                                public HBox createGroup(RadioButton... buttons) {
                                    ToggleGroup group = new ToggleGroup();
                                    HBox box = new HBox();
                                    group.getToggles().addAll(buttons);
                                    box.getChildren().addAll(buttons);
                                    box.setSpacing(3);
                                    return box;
                                }""")
                        .build()
                        .getRoot()
        );
    }

    public HBox createGroup(RadioButton... buttons) {
        ToggleGroup group = new ToggleGroup();
        HBox box = new HBox();
        group.getToggles().addAll(buttons);
        box.getChildren().addAll(buttons);
        box.setSpacing(3);
        return box;
    }

    public RadioButton createDemo(String text) {
        RadioButton container = new RadioButton(text);
        return container;
    }

}
