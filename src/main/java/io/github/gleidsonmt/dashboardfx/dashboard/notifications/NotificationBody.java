package io.github.gleidsonmt.dashboardfx.dashboard.notifications;

import javafx.scene.layout.VBox;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  23/04/2025
 */
public class NotificationBody extends VBox {

    public NotificationBody(NotificationManager manager) {
        getStyleClass().addAll("rounded", "padding-20", "bg-white");
        setFillWidth(true);
    }
}
