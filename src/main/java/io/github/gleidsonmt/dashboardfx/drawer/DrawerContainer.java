package io.github.gleidsonmt.dashboardfx.drawer;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  11/03/2025
 */
public class DrawerContainer extends ScrollPane {

    public DrawerContainer(VBox container) {
        this.setContent(container);
        this.setFitToWidth(true);
        this.setFitToHeight(true);
    }

    public void setContainer(VBox container) {
        this.setContent(container);
    }
}
