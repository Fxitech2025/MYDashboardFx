package io.github.gleidsonmt.dashboardfx.components;

import io.github.gleidsonmt.dashboardfx.utils.Assets;
import io.github.gleidsonmt.glad.controls.avatar.AvatarCircleView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.util.List;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  14/03/2025
 */
public class AvatarStackedCircle extends StackPane {

    public AvatarStackedCircle() {
        this(5);
    }

    public AvatarStackedCircle(int max, Image... images) {
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(0));
        int translate = 0;
        for (int i = 0; i < Math.min(images.length, max); i++) {
            AvatarCircleView avatar = new AvatarCircleView(images[i]);
            avatar.setTranslateX(translate+=25);
            this.getChildren().add(avatar);
        }
        if (images.length - 3 > 0) {
            Label label = new Label(images.length - 3 + "+");
            label.setAlignment(Pos.CENTER);
            label.setPrefSize(40, 40);
            label.getStyleClass().addAll("border-white", "border-2", "bg-accent", "bg-insets-1", "text-white", "padding-5", "round", "bold");
            label.setTranslateX(translate + 25);
            this.getChildren().add(label);
        }

        this.setPadding(new Insets(0, 0,0, -25));
    }
}
