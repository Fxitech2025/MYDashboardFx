package io.github.gleidsonmt.dashboardfx.dashboard.notifications;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  23/04/2025
 */
public class NotificationPane extends ScrollPane {

    public NotificationPane(Node content) {
        setFitToWidth(true);
        setFitToHeight(true);
        setContent(content);

        setPrefWidth(600);
        setMaxWidth(600);
    }
}
