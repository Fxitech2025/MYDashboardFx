package io.github.gleidsonmt.dashboardfx.drawer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Objects;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  31/03/2025
 */
public class  BoxModule extends VBox {

    private String name;

    public BoxModule(String name, ToggleButton toggleButton) {
        this.name = name;
        Text title = new Text(name);

        getChildren().add(title);
        VBox.setMargin(title, new Insets(5));

        this.getChildren().addListener((ListChangeListener<Node>) change -> {
            if (change.next()) {
                if (change.wasAdded()) {
                    change.getAddedSubList()
                            .forEach(el ->
                                    VBox.setMargin(el, new Insets(0,20,0,20)));
                }
            }
        });
        getChildren().add(toggleButton);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}