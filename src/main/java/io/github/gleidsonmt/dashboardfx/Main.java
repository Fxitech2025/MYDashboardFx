package io.github.gleidsonmt.dashboardfx;

import io.github.gleidsonmt.dashboardfx.breadcrumb.BreadCrumbBar;
import io.github.gleidsonmt.dashboardfx.drawer.Drawer;
import io.github.gleidsonmt.dashboardfx.presentation.Scroll;
import io.github.gleidsonmt.glad.base.Container;
import io.github.gleidsonmt.glad.base.Layout;
import io.github.gleidsonmt.glad.base.internal.Module;
import io.github.gleidsonmt.glad.base.internal.View;
import io.github.gleidsonmt.glad.base.responsive.Break;
import io.github.gleidsonmt.glad.controls.button.IconButton;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  10/06/2025
 */
public class Main extends View {

    private VBox container = new VBox();
    private ScrollPane body = new ScrollPane();

    private IconButton hamb = new IconButton(new SVGIcon(Icon.MENU));
    private NavBar navBar = new NavBar();
    private BreadCrumbBar crumb = new BreadCrumbBar();

//    private CardUserOptions card;

    public Main(Layout layout, Drawer drawer) {
        super("Main");
        setContent(container);
        layout.setView(this);
        body.getStyleClass().addAll("fit-width fit-height".split(" "));

        container.getChildren().setAll(navBar, body);
        VBox.setVgrow(body, Priority.ALWAYS);

        navBar.add(crumb, 0, 0);

        crumb.currentModuleProperty().bind(drawer.currentModuleProperty());
//        card = new CardUserOptions(new User(Assets.getImage("default_avatar.jpg", 80), "johndoe54@gmail.com", "Jhon Doe"));

        drawer.currentModuleProperty().addListener((_, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue instanceof View view) {
                    if (view.getOnEnter() != null) view.getOnEnter().handle(new ActionEvent());
                    updateView(view.getContent());
                }
            } else if (oldValue != null) {
                if (oldValue instanceof View view) {
                    if (view.getOnExit() != null) view.getOnExit().handle(new ActionEvent());
                }
            }
        });

        layout.addPoint(_ -> {
            navBar.getChildren().add(0, hamb);
            GridPane.setColumnIndex(crumb, 1);
//            GridPane.setColumnIndex(card, 4);
        }, Break.MOBILE);

        layout.addPoint(_ -> {
//            if (behavior().isDrawerAbsolute()) {
//                wrapper().hide();
//            }
//            getContainer().setLeft(drawer);
            navBar.getChildren().remove(hamb);
//            GridPane.setColumnIndex(crumb, 0);
//            GridPane.setColumnIndex(card, 3);
        },  Break.SM, Break.MD, Break.WIDE);
    }

    private void updateView(Node node) {
        body.setContent(node);
    }

}
