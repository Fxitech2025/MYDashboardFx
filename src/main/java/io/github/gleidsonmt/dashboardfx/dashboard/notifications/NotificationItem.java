package io.github.gleidsonmt.dashboardfx.dashboard.notifications;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleButton;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  24/04/2025
 */
public class NotificationItem extends ToggleButton {
    public NotificationItem() {
        getStyleClass().add("notification-item");
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        setMaxWidth(Double.MAX_VALUE);
    }
}
