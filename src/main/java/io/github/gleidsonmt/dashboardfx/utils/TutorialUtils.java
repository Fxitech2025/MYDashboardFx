package io.github.gleidsonmt.dashboardfx.utils;

import io.github.gleidsonmt.dashboardfx.drawer.Drawer;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  15/03/2025
 */
public class TutorialUtils {

    public static @NotNull Node createCardLink(String placeholder, URI uri) {
        SVGPath path = new SVGPath();
        path.setContent("M12 0c-6.626 0-12 5.373-12 12 0 5.302 3.438 9.8 8.207 11.387.599.111.793-.261.793-.577v-2.234c-3.338.726-4.033-1.416-4.033-1.416-.546-1.387-1.333-1.756-1.333-1.756-1.089-.745.083-.729.083-.729 1.205.084 1.839 1.237 1.839 1.237 1.07 1.834 2.807 1.304 3.492.997.107-.775.418-1.305.762-1.604-2.665-.305-5.467-1.334-5.467-5.931 0-1.311.469-2.381 1.236-3.221-.124-.303-.535-1.524.117-3.176 0 0 1.008-.322 3.301 1.23.957-.266 1.983-.399 3.003-.404 1.02.005 2.047.138 3.006.404 2.291-1.552 3.297-1.23 3.297-1.23.653 1.653.242 2.874.118 3.176.77.84 1.235 1.911 1.235 3.221 0 4.609-2.807 5.624-5.479 5.921.43.372.823 1.102.823 2.222v3.293c0 .319.192.694.801.576 4.765-1.589 8.199-6.086 8.199-11.386 0-6.627-5.373-12-12-12z");
        path.setStyle("-fx-fill: -text-color;");
        HBox box = new HBox();
        box.getStyleClass().addAll("border-2", "border-light-gray-2", "padding-10", "radius-5");
        Hyperlink hyperlink = createLink(placeholder, uri);
        box.getChildren().addAll(path, new Separator(Orientation.VERTICAL), hyperlink);
        box.setSpacing(10);
        return box;
    }

    public static @NotNull Hyperlink createLink(String placeholder, URI uri) {
        Hyperlink hyperlink = new Hyperlink(placeholder);
        hyperlink.setOnAction(_ -> {
            try {
                Desktop.getDesktop().browse(uri);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        return hyperlink;
    }

    public static @NotNull Hyperlink createLink(String placeholder, String moduleName) {
        Hyperlink hyperlink = new Hyperlink(placeholder);
        hyperlink.getStyleClass().addAll("h5");
        hyperlink.setOnAction(_ -> {
            Drawer drawer = (Drawer) hyperlink.getScene().lookup("#drawer");
            drawer.navigate(moduleName);
        });
        return hyperlink;
    }

    public static Node createTextWithLink(String text, String placeholder, String moduleName) {
        return createTextWithLink(text,placeholder, moduleName, null);
    }

    public static Node createTextWithLink(String _text, String placeholder, String moduleName, String topic) {
        Text text = new Text(_text);
        HBox box = new HBox(
                text,
                createLink(placeholder, moduleName, topic)
        );
        box.getStyleClass().add("h5");

        box.setAlignment(Pos.CENTER_LEFT);
        return box;
    }


    public static @NotNull Hyperlink createLink(String placeholder, String moduleName, String topic) {
        Hyperlink hyperlink = new Hyperlink(placeholder);
        hyperlink.setOnAction(_ -> {
            Drawer drawer = (Drawer) hyperlink.getScene().lookup("#drawer");
            drawer.navigate(moduleName, topic);
        });
        return hyperlink;
    }
}
