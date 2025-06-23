package io.github.gleidsonmt.dashboardfx.dashboard;

import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  08/05/2025
 */
public class CloseButton extends Button {

    public CloseButton(EventHandler<ActionEvent> event) {
        this.setGraphic(new SVGIcon(Icon.CLEAR));
        this.getStyleClass().addAll("min-size-30", "bg-light-gray", "round", "border-light-gray-2", "display-graphic", "cursor-hand");
        this.setStyle("-icon-color: -dark-gray;");

        this.setOnAction(event);
    }
}
