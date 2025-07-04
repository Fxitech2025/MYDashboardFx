package io.github.gleidsonmt.dashboardfx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  10/06/2025
 */
public class NavBar extends GridPane {

    public NavBar() {
        setPadding(new Insets(10));
        setMinHeight(40);
        setAlignment(Pos.CENTER_LEFT);
    }
}
