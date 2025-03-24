package io.github.gleidsonmt.dashboardfx.utils.pages;

import io.github.gleidsonmt.dashboardfx.utils.Assets;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  19/03/2025
 */
public class BuildingPage extends VBox {

    public BuildingPage() {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(20));

        Region region = new Region();
        setVgrow(region, Priority.ALWAYS);

        Image img = Assets.getImage("content_machine.jpeg");
        region.setBackground(
                new Background(new BackgroundImage(
                        img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT, new BackgroundSize(400, 400, true, true, true, false)
                )));

        region.setMaxSize(600, 600);

        Text title = new Text("This module it's not done yet");
        title.getStyleClass().addAll( "h3");
        Hyperlink link = new Hyperlink("See more");
        this.getChildren().setAll(title, region, link);

    }
}
