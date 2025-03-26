package io.github.gleidsonmt.dashboardfx.material;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  25/03/2025
 */
public class MaterialColumn extends VBox {

    private final ObservableList<String> colors = FXCollections.observableArrayList();

    public void addColor(MaterialItem item) {
        this.colors.add(item.getColor());
        this.getChildren().add(item);
        setSpacing(5);
    }

    @Override
    public String toString() {
        return "MaterialColumn{" + "\n\tcolors=" + colors +
               "\n}";
    }
}
