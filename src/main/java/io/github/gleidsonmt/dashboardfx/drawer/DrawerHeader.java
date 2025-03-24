package io.github.gleidsonmt.dashboardfx.drawer;

import io.github.gleidsonmt.dashboardfx.App;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Objects;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  11/03/2025
 */
public class DrawerHeader extends GridPane {

    public DrawerHeader() {

        setPrefSize(200, 100);
        this.setPadding(new Insets(10));
//        this.setGridLinesVisible(true);
        this.setHgap(10);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setImage(new Image(Objects.requireNonNull(App.class.getResource("img/logo_128.png")).toExternalForm()));

        Text title = new Text("Blue Galaxy");
//        Font.loadFont(Objects.requireNonNull(App.class.getResource("fonts/Instagram-Sans-Bold.ttf")).toExternalForm(), 16);
//        title.setFont(Font.loadFont(App.class.getResource("fonts/Instagram-Sans.ttf").toExternalForm(), 16));
        title.setStyle("-fx-font-family: \"Instagram Sans\"; -fx-font-size: 28px; -fx-fill: -fx-accent; -fx-font-weight: bold;");
//        title.setFont(Font.font("Instagram Sans Bold", 22));

        Text legend = new Text("Gleidson, Inc. v0.7.223");
        legend.setStyle("-fx-text-weight: 14pt");

        this.add(imageView, 0,0);
        this.add(title, 1,0);
        this.add(legend, 1,1);

        GridPane.setHgrow(title, Priority.ALWAYS);
        GridPane.setRowSpan(imageView, 2);

    }
}
