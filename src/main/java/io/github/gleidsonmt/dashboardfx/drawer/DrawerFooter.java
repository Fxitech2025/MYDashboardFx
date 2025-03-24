package io.github.gleidsonmt.dashboardfx.drawer;

import io.github.gleidsonmt.dashboardfx.model.User;
import io.github.gleidsonmt.glad.controls.avatar.AvatarCircleView;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.geometry.VPos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  16/10/2024
 */
public class DrawerFooter extends GridPane  {

//    private final ObjectProperty<Image> avatar = new SimpleObjectProperty<>();
    private final AvatarCircleView avatarView = new AvatarCircleView();
    private final GridPane email;
    private final Label name;
    private final ContextMenu options;


    public DrawerFooter(User user) {
        this.avatarView.setImage(user.getAvatar());

        this.getChildren().add(avatarView);
        this.setId("header");
        this.email = createEmailComponent(user.getUsername());
        this.name = createNameComponent(user.getName() );
        this.options = createOptions(user);
        init();
    }

    public void init() {
        this.setPadding(new Insets(5, 5,0,5));
        this.getChildren().setAll(avatarView, email, name);
        avatarView.setRadius(23);
        GridPane.setRowSpan(avatarView, 2);

        GridPane.setColumnIndex(avatarView, 0);
        GridPane.setRowIndex(avatarView, 0);

        GridPane.setColumnIndex(name, 1);
        GridPane.setRowIndex(name, 0);

        GridPane.setColumnIndex(email, 1);
        GridPane.setRowIndex(email, 1);

        GridPane.setValignment(name, VPos.BOTTOM);
        GridPane.setValignment(email, VPos.TOP);

        GridPane.setHgrow(email, Priority.ALWAYS);
        GridPane.setVgrow(name, Priority.ALWAYS);
        GridPane.setVgrow(email, Priority.ALWAYS);

        this.setHgap(10);
        this.setVgap(2);

//        VBox.setMargin(this, new Insets(10));
        VBox.setMargin(this, new Insets(0, 5,20,5));

    }

    private Label createNameComponent(String _text) {
        Label text = new Label(_text);
        text.setWrapText(true);
        text.getStyleClass().addAll("h5", "bold");
        return text;
    }

    private GridPane createEmailComponent(String _text) {
        Text text = new Text(_text);
        text.getStyleClass().addAll( "h6");

        SVGIcon svgIcon = new SVGIcon(Icon.EXPAND_ALL);
        svgIcon.setScale(0.8);

        GridPane container = new GridPane();
        container.setHgap(5);
        container.getChildren().addAll(text, svgIcon);

        GridPane.setColumnIndex(text, 0);
        GridPane.setColumnIndex(svgIcon, 1);

        return container;
    }

    private ContextMenu createOptions(User user) {

        ContextMenu options = new ContextMenu();

        MenuItem menuSettings = new MenuItem("Settings");
        menuSettings.getStyleClass().add("menu-item-first");
        menuSettings.setGraphic(new SVGIcon(Icon.SETTINGS));
        
//        menuSettings.setOnAction(e -> {
//            Root root = (Root) this.getScene().getRoot();
//            root.setLayout(new SettingsView(user));
//        });
        
        MenuItem menuManageAccount = new MenuItem("Manage Account");
        menuManageAccount.getStyleClass().add("menu-item-last");
        menuManageAccount.setGraphic(new SVGIcon(Icon.MANAGE_ACCOUNTS));

        options.getItems().addAll(menuManageAccount, new SeparatorMenuItem(), menuSettings);
        options.getStyleClass().add("drawer-context-menu");

        this.setOnMouseClicked(e -> {
            if (options.isShowing()) return;
            options.show(this, Side.BOTTOM, 0, e.getY() -20);
        });
        return options;
    }
}
