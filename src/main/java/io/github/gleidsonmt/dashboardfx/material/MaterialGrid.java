package io.github.gleidsonmt.dashboardfx.material;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.TilePane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  25/03/2025
 */
public class MaterialGrid extends TilePane {

    public MaterialGrid() {
        this.setPadding(new Insets(20));
        this.setHgap(5);
        this.setVgap(5);
    }

    public void setColumns(ObservableList<MaterialColumn> columns) {
        this.getChildren().setAll(columns);
    }
}
