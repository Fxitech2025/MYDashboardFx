package io.github.gleidsonmt.dashboardfx.presentation.presentations.controls;

import io.github.gleidsonmt.dashboardfx.ResizablePane;
import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  20/02/2025
 */
public class SVGIconPres extends StackPane {

    public SVGIconPres() {

        getChildren().setAll(
                new Tutorial()
                        .h2("Icons", null)
                        .text("""
                               This icon is minor collection of google icons.
                                """)
                        .link("Google Fonts", "https://fonts.google.com/icons")
//                        .legend("(The base font here is set to Poppins, by default is not apply, but it's better to add all fonts before the app load. At the end you can see the code to add.)")
                        // .link([link to explanation]) ir para temas

                        .demo(new SVGIcon(Icon.MENU))
                        .code("SVGIcon icon = new SVGIcon(Icon.MENU)")
                        .h3("Options")
//                        .demo(createDemos())
                        .demo(demos())
//                        .demo(new FlowPane(new ResizablePane(demos())))
                        .build()
                        .getRoot()
        );


    }

    private ObservableList<Node> demos() {
        ObservableList<Node> list = FXCollections.observableArrayList();
        for (Icon icon : Icon.values()) {
            Label label = new Label(icon.name());
            FlowPane.setMargin(label, new Insets(10));
            label.setGraphic(new SVGIcon(icon));
            label.setContentDisplay(ContentDisplay.TOP);
            list.add(label);

        }
        return list;
    }
    private Node createDemos() {
        TilePane flowPane = new TilePane();
        flowPane.setStyle("-fx-background-color: red;");
        flowPane.setHgap(10);
        flowPane.setVgap(10);

        for (Icon icon : Icon.values()) {
            Label label = new Label(icon.name());
            label.setGraphic(new SVGIcon(icon));
            label.setContentDisplay(ContentDisplay.TOP);
            flowPane.getChildren().add(label);

        }

        return flowPane;
    }

    private Label createDemo( String _text, String... _classes) {
        return createDemo(null, _text, _classes);
    }
    private Label createDemo(Node graphic, String _text, String... _classes) {
        Label text = new Label(_text);
        text.setGraphic(graphic);
        text.getStyleClass().addAll(_classes);
        return text;
    }
}
