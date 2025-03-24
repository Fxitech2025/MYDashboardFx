package io.github.gleidsonmt.dashboardfx.utils;

import io.github.gleidsonmt.dashboardfx.drawer.Drawer;
import io.github.gleidsonmt.dashboardfx.presentation.Scroll;
import javafx.scene.control.Hyperlink;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  15/03/2025
 */
public class TutorialUtils {

    public static Hyperlink createLink(String placeholder, String moduleName) {
        Hyperlink hyperlink = new Hyperlink(placeholder);
        hyperlink.setOnAction(e -> {
            Drawer drawer = (Drawer) hyperlink.getScene().lookup("#drawer");
            drawer.navigate(moduleName);
        });
        return hyperlink;
    }

    public static Hyperlink createLink(String placeholder, String moduleName, String topic) {
        Hyperlink hyperlink = new Hyperlink(placeholder);
        hyperlink.setOnAction(e -> {
            Drawer drawer = (Drawer) hyperlink.getScene().lookup("#drawer");
            drawer.navigate(moduleName, topic);

//            Scroll.scrollTo(scroll, l)
//                    .setOnFinished(e -> rolling = true);
        });
        return hyperlink;
    }
}
