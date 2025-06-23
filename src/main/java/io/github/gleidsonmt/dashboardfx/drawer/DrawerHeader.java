package io.github.gleidsonmt.dashboardfx.drawer;

import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

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

//        ImageView logoTest = new ImageView();
//        logoTest.setFitWidth(50);
//        logoTest.setFitHeight(50);
//        logoTest.setImage(new Image(Objects.requireNonNull(AppOld.class.getResource("img/logo_128.png")).toExternalForm()));

        Text title = new Text("Blue Galaxy");
//        Font.loadFont(Objects.requireNonNull(AppOld.class.getResource("fonts/Instagram-Sans-Bold.ttf")).toExternalForm(), 16);
//        title.setFont(Font.loadFont(AppOld.class.getResource("fonts/Instagram-Sans.ttf").toExternalForm(), 16));
        title.setStyle("-fx-font-family: \"Instagram Sans\"; -fx-font-size: 28px; -fx-fill: -fx-accent; -fx-font-weight: bold;");

        Text legend = new Text("Gleidson, Inc. v0.7.223");
        legend.setStyle("-fx-text-weight: 14pt");

        Text logoTest = new Text("G");
        logoTest.setStroke(Color.WHITE);
        logoTest.setRotate(180);
        logoTest.setStyle("-fx-fill: -fx-accent; -fx-font-size: 62px; -fx-font-family: \"JetBrains Mono\"; -fx-font-weight: bold;");
        logoTest.getStyleClass().addAll("depth-1", "font-instagram");
        logoTest.setStrokeWidth(1);
        logoTest.setUnderline(true);
        logoTest.setWrappingWidth(50);
        logoTest.setTextAlignment(TextAlignment.CENTER);


        this.add(logoTest, 0,0);
        this.add(title, 1,0);
        this.add(legend, 1,1);

        GridPane.setHgrow(title, Priority.ALWAYS);
        GridPane.setRowSpan(logoTest, REMAINING);

        GridPane.setValignment(title, VPos.BOTTOM);
        GridPane.setValignment(legend, VPos.TOP);

        RowConstraints rowOne = new RowConstraints();
        RowConstraints rowTwo = new RowConstraints();
        rowOne.setPercentHeight(50);
        rowTwo.setPercentHeight(50);
        this.getRowConstraints().addAll(rowOne, rowTwo);
    }
}
