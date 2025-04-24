package io.github.gleidsonmt.dashboardfx.dashboard.notifications;

import io.github.gleidsonmt.dashboardfx.utils.Assets;
import io.github.gleidsonmt.dashboardfx.utils.StringUtils;
import io.github.gleidsonmt.glad.controls.avatar.AvatarView;
import io.github.gleidsonmt.glad.controls.button.Button;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.time.*;
import java.time.format.DateTimeFormatter;

import static javafx.scene.layout.GridPane.REMAINING;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  23/04/2025
 */
public class NotificationManager {

    private NotificationPane pane;
    private NotificationBody body;
    private VBox notificationsContainer;
    private ObservableList<Notification> notifications;

    public NotificationManager() {
        notifications = FXCollections.observableArrayList();
        body = new NotificationBody(this);
        pane = new NotificationPane(body);

        notificationsContainer = new VBox();
        body.getChildren().addAll(createHeader(), new Separator(), notificationsContainer, new Separator(), createFooter());

        body.setSpacing(10);

        NotificationFactory factory = new NotificationFactory();

//        body.setPrefSize(400, 600);

        notifications.addListener(new ListChangeListener<Notification>() {
            @Override
            public void onChanged(Change<? extends Notification> c) {
                if (c.next()) {
                    if (c.wasAdded()) {
                        for (Notification notification : c.getAddedSubList()) {
                            notificationsContainer.getChildren().add(factory.create(notification));
                        }
                    }
                }
            }
        });
    }

    private Node createHeader() {
        GridPane header = new GridPane();

        Text title = new Text("Your notifications");
        title.getStyleClass().addAll("h4", "bold");
        Hyperlink link = new Hyperlink("Mark all as read");
        link.getStyleClass().addAll("h5", "bold");
        link.setGraphic(new SVGIcon(Icon.DONE_ALL));

        header.add(title, 0, 0);
        header.add(link, 1, 0);

        GridPane.setHgrow(title, Priority.ALWAYS);
        GridPane.setHalignment(link, HPos.RIGHT);
        return header;
    }

    private Node createFooter() {

        GridPane footer = new GridPane();

        Button viewAll = new Button("View all notifications");
        Button manage = new Button("Manage notifications");
        manage.getStyleClass().addAll("flat");

        footer.add(manage, 0, 0);
        footer.add(viewAll, 1, 0);

        GridPane.setHalignment(viewAll, HPos.RIGHT);

        ColumnConstraints one = new ColumnConstraints();
        one.setPercentWidth(50);
        ColumnConstraints two = new ColumnConstraints();
        two.setPercentWidth(50);
        footer.getColumnConstraints().addAll(one, two);
        return footer;
    }


    public void add(Notification notification) {
        notifications.add(notification);
    }

    public Region getRoot() {
        return pane;
    }


}
