package io.github.gleidsonmt.dashboardfx.dashboard;

import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import io.github.gleidsonmt.glad.responsive.Break;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  28/03/2025
 */
public class GridBarView extends Pane {

    
    public GridBarView() {
        setMinHeight(40);
        this.getStyleClass().addAll("border", "border-light-gray-2", "border-2", "pattern-circle");
        this.sceneProperty().addListener((observableVal, oldVal, newVal) -> {
            if (newVal != null) {
                for (Break br : Break.values()) {
                    Node create = createGrid(br);
                    create.setLayoutY(10);
                    getChildren().add(create);

                }
            }
        });
      
    }

    private Node createGrid(Break br) {
        GridPane grid = new GridPane();
        Text title = new Text(br.name());
        Text size = new Text(String.valueOf(br.getMax() ));

        title.getStyleClass().addAll("h6", "bold");
        size.getStyleClass().addAll("h6", "bold");
        SVGIcon icon = new SVGIcon(Icon.ARROW_RIGHT_ALT);
        title.setRotate(45);
        size.setRotate(45);
        icon.setRotate(90);

        grid.setLayoutX(br.getMax() - 10);

        grid.add(title, 0,0);
        grid.add(size, 1,0);
        grid.add(icon, 0,1);


        return grid;
    }
}
