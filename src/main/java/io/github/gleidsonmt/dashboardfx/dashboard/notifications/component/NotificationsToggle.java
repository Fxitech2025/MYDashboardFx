package io.github.gleidsonmt.dashboardfx.dashboard.notifications.component;

import io.github.gleidsonmt.dashboardfx.dashboard.notifications.factory.Notification;
import io.github.gleidsonmt.dashboardfx.dashboard.notifications.factory.NotificationManager;
import io.github.gleidsonmt.dashboardfx.dashboard.notifications.factory.NotificationType;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  24/04/2025
 */
public class NotificationsToggle extends HBox {

    private final ToggleGroup group = new ToggleGroup();
    private final NotificationManager manager;

    public NotificationsToggle(NotificationManager manager) {
        this.manager = manager;

        setMinHeight(50);
        getStyleClass().add("notifications-toggle");

        var viewAll =  new CustomToggle("View All", manager, null);
        var mentions =  new CustomToggle("Mentions", manager, NotificationType.MENTION);
        var follow = new CustomToggle("Followers", manager, NotificationType.FOLLOW);
        var invite = new CustomToggle("Invites", manager, NotificationType.INVITE);

        getChildren().setAll( viewAll,  mentions, follow, invite);

        getChildren().forEach(e -> group.getToggles().add((Toggle) e));
        group.selectToggle((Toggle) getChildren().getFirst());

        viewAll.sizeProperty().bind(Bindings.size(manager.getNotifications()));

        FilteredList<NotificationItem<Notification>> filteredFollowers = new FilteredList<>(manager.getNotifications(),
                item -> item.getValue().getType() == NotificationType.FOLLOW);

        FilteredList<NotificationItem<Notification>> filteredInvited = new FilteredList<>(manager.getNotifications(),
                item -> item.getValue().getType() == NotificationType.INVITE);

        follow.sizeProperty().bind(Bindings.size(filteredFollowers));
        invite.sizeProperty().bind(Bindings.size(filteredInvited));

    }

}

class CustomToggle extends ToggleButton {

    private final IntegerProperty size = new SimpleIntegerProperty(0);

    public CustomToggle(String text, NotificationManager manager, NotificationType type) {
        super(text);
        getStyleClass().addAll("notification-toggle", "cursor-hand");
        this.prefWidthProperty().bind(this.widthProperty().divide(4));
        HBox.setHgrow(this, Priority.ALWAYS);
        setMaxWidth(Double.MAX_VALUE);
        setPrefHeight(35);
        Text textSize = new Text();
        setGraphic(textSize);
        textSize.textProperty().bind(Bindings.convert(size));
        setContentDisplay(ContentDisplay.RIGHT);

        selectedProperty().addListener((_, _, newValue) -> {
            if (newValue) {
                manager.getFilteredNotifications().setPredicate(item -> type == null || item.getValue().getType() == type);
            }
        });
    }

    public IntegerProperty sizeProperty() {
        return size;
    }
}