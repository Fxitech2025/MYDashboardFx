package io.github.gleidsonmt.dashboardfx.presentation.drawer;

import io.github.gleidsonmt.dashboardfx.Main;
import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  16/04/2025
 */
public class DrawerExample extends StackPane {

    public DrawerExample() {
        getChildren().setAll(
                new Tutorial()
                        .h3("Drawer")
                        .text("Drawer style examples.")
                        .demo(new SimpleDrawer())
                        .build()
                        .getRoot()
        );
    }



}
