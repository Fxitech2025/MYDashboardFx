package io.github.gleidsonmt.dashboardfx.dashboard.notifications;

import io.github.gleidsonmt.dashboardfx.utils.StringUtils;
import io.github.gleidsonmt.glad.controls.avatar.AvatarView;
import io.github.gleidsonmt.glad.controls.button.Button;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static javafx.scene.layout.GridPane.REMAINING;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  24/04/2025
 */
public class NotificationFactory {

    private final ToggleGroup group = new ToggleGroup();

    public Node create(Notification notification) {

        NotificationItem item = new NotificationItem();
        group.getToggles().add(item);
        GridPane card = createCard();
        item.maxHeightProperty().bind(card.heightProperty());
        item.setGraphic(card);

        TextFlow title = new TextFlow();
        Text titleUsername = new Text(notification.getUser().getUsername());
        titleUsername.getStyleClass().addAll("h5", "bold");

        title.getChildren().add(titleUsername);

        String formated = DateTimeFormatter
                .ofPattern("EEEE hh:mm a")
                .format(notification.getDateTime());

        Text legend = new Text(StringUtils.capitalize(formated));
        legend.getStyleClass().addAll("h6");

        Node avatar =
                notification.getType() == NotificationType.LIKE ?
                        createLikedAvatar(new AvatarView(notification.getUser().getAvatar(), 50)) :
                        new AvatarView(notification.getUser().getAvatar(), 50);

        card.add(avatar, 0, 0);
        card.add(title, 1, 0);
        card.add(legend, 1, 1);

        Text passed = new Text(StringUtils.formatDuration(notification.getDateTime(), LocalDateTime.now()));

        if (!notification.visualized()) {
            Circle circle = new Circle();
            circle.setStyle("-fx-fill: -indigo");
            circle.setRadius(5);
            card.add(circle, 3, 0);
            GridPane.setHalignment(circle, HPos.RIGHT);
        }

        card.add(passed, 2, 1);
        GridPane.setHalignment(passed, HPos.RIGHT);
        GridPane.setColumnSpan(passed, REMAINING);
        GridPane.setRowSpan(avatar, 2);

        switch (notification.getType()) {
            case FOLLOW -> {
                Text textContent = new Text(" followed you");
                textContent.getStyleClass().addAll("h5");
                title.getChildren().add(textContent);
            }
            case COMMENT -> {
                Text textContent = new Text(" commented on your post");
                textContent.getStyleClass().addAll("h5");

                title.getChildren().add(textContent);

                if (notification instanceof CommentNotification commentNotification) {
                    Text comment = new Text(commentNotification.getPost());
                    TextFlow flow = new TextFlow(comment);
                    flow.getStyleClass().addAll("padding-2", "bg-light-gray", "rounded", "bold");
                    card.add(flow, 1, 2);
                    GridPane.setColumnSpan(flow, REMAINING);
                }

            }

            case LIKE -> {
                Text textContent = new Text(" liked your post");
                textContent.getStyleClass().addAll("h5");
                title.getChildren().add(textContent);
            }

            case INVITE -> {
                Text textContent = new Text(" invited you to join the DashboardFX community");
                textContent.getStyleClass().addAll("h5");
                title.getChildren().add(textContent);
                card.add(createActions(), 1, 2);
            }
        }

        return item;
    }

    private Node createActions() {
        HBox box = new HBox();
        Button confirm = new Button("Accept");
        Button cancel = new Button("Decline");
        cancel.setCancelButton(true);
        box.getChildren().addAll(cancel,confirm);
        box.setSpacing(10);
        box.setPadding(new Insets(10));
        return box;
    }

    private Node createLikedAvatar(AvatarView avatarView) {
        Label label = new Label();
        label.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        label.getStyleClass().addAll( "bg-accent", "heart", "padding-5", "border-1", "border-white", "rounded",  "text-white");
        double w = 15, h = 15;
        label.setCache(true);
        label.setCacheHint(CacheHint.QUALITY);
        label.setPrefSize(w, h);
        label.setMinSize(w, h);
        label.setMaxSize(w, h);
        StackPane.setAlignment(label, Pos.BOTTOM_RIGHT);
        return new StackPane(avatarView, label);
    }

    private GridPane createCard() {
        GridPane card = new GridPane();
        card.setHgap(15);
        card.setPadding(new Insets(5));

        ColumnConstraints one = new ColumnConstraints();
        one.setPercentWidth(10);
        ColumnConstraints two = new ColumnConstraints();
        two.setPercentWidth(70);
        ColumnConstraints three = new ColumnConstraints();
        three.setPercentWidth(10);
        ColumnConstraints four = new ColumnConstraints();
        four.setPercentWidth(10);
        card.getColumnConstraints().addAll(one, two, three, four);

        return card;
    }
}
