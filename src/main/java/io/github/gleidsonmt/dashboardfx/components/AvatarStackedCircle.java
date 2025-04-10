package io.github.gleidsonmt.dashboardfx.components;

import io.github.gleidsonmt.dashboardfx.utils.Assets;
import io.github.gleidsonmt.glad.controls.avatar.AvatarCircleView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.util.List;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  14/03/2025
 */
public class AvatarStackedCircle extends Group {

    public AvatarStackedCircle(int max, Image... images) {
        this(max, 20, images);
    }

    public AvatarStackedCircle(int max, double radius, Image... images) {
        int translate = 0;
        for (int i = 0; i < Math.min(images.length, max); i++) {
            AvatarCircleView avatar = new AvatarCircleView(images[i]);
            avatar.setRadius(radius);
            avatar.setLayoutX(translate+=25);
            this.getChildren().add(avatar);
        }
        if (images.length - 3 > 0) {
            Label label = new Label(images.length - 3 + "+");
            label.setAlignment(Pos.CENTER);
            label.setPrefSize(40, 40);

            label.getStyleClass().addAll("display-center","border-white", "border-2", "bg-accent", "bg-insets-1", "text-white", "padding-5", "round", "bold");
            label.setLayoutX(translate+(radius/ 2));
            label.setLayoutY(-(radius));
            this.getChildren().add(label);
        }
    }
}
