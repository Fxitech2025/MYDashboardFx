package io.github.gleidsonmt.dashboardfx.presentation.core;

import javafx.scene.layout.GridPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  18/04/2025
 */
public class NavBar extends GridPane {


    public NavBar() {
        getStyleClass().addAll("nav-bar", "min-h-40", "padding-5");
        setHgap(10);
    }

}
