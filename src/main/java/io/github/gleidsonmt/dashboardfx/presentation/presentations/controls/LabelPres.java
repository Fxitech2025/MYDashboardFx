package io.github.gleidsonmt.dashboardfx.presentation.presentations.controls;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import io.github.gleidsonmt.dashboardfx.utils.TutorialUtils;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import io.github.gleidsonmt.presentation.Row;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  20/02/2025
 */
public class LabelPres extends StackPane {

    public LabelPres() {
        getChildren().setAll(
                new Tutorial()
                        .indicators()
                        .h2("Label", null)

                        .text("""
                                Label is a non-editable text control. 
                                A Label is useful for displaying text that is required to fit within a specific space, and thus may need to use an ellipsis or truncation to size the string to fit. 
                                Labels also are useful in that they can have mnemonics which, if used, will send focus to the Control listed as the target of the labelFor property.
                                """)
                        .legend("javafx.scene.control.Label")
                        .legend("All classes in (Text) works in the text inside label.")
                        .legend("All classes in (Region) can by apply in label.")
//                        .legend("(The base font here is set to Poppins, by default, is not apply, but it's better to add all fonts before the app load. At the end you can see the code to add.)")
                        // .link([link to explanation]) ir para temas

                        .h3("Default", "Label")
                        .demo(new Label("Lorem ipsum dolor color"))
                        .code("Label label = new Label(\"Lorem ipsum dolor color\");")

                        .h3("Graphic", "Label")
                        .text("An optional icon for the Labeled.")
                        .legend("Every node object can be an icon.")
                        .node(TutorialUtils.createLink("See more icons in SVGIcon", "SVGIcon"))
                        .demo(
                                createDemo(new SVGIcon(Icon.MENU), "Menu"),
                                createDemo(new SVGIcon(Icon.ARROW_BACK), "Arrow"),
                                createDemo(new SVGIcon(Icon.LOCATION_ON), "Location")
                        )
                        .h3("Display", "Label")
                        .table(
                                new Row("display-top", " -fx-content-display: top;"),
                                new Row("display-right ", "-fx-content-display: right;"),
                                new Row("display-bottom", "-fx-content-display: bottom;"),
                                new Row("display-left", "-fx-content-display: left;"),
                                new Row("display-center", "-fx-content-display: center;"),
                                new Row("display-graphic", "-fx-content-display: graphic_only;"),
                                new Row("display-text", " -fx-content-display: text_only;")
                        )
                        .demo(
                                createDemo(new SVGIcon(Icon.ADD),"Label", "display-top", "border-2", "border-light-gray-2", "padding-5"),
                                createDemo(new SVGIcon(Icon.ADD),"Label", "display-right", "border-2","border-light-gray-2", "padding-5"),
                                createDemo(new SVGIcon(Icon.ADD),"Label", "display-bottom", "border-2", "border-light-gray-2", "padding-5"),
                                createDemo(new SVGIcon(Icon.ADD),"Label", "display-left", "border-2","border-light-gray-2", "padding-5"),
                                createDemo(new SVGIcon(Icon.ADD),"Label", "display-center", "border-2", "border-light-gray-2", "padding-5"),
                                createDemo(new SVGIcon(Icon.ADD),"Label", "display-graphic", "border-2", "border-light-gray-2", "padding-5"),
                                createDemo(new SVGIcon(Icon.ADD),"Label", "display-text","border-2", "border-light-gray-2", "padding-5")
                        )
                        .code("label.setGraphic(new SVGIcon(Icon.MENU));")
                        .h3("Customizing", "Label")
                        .demo(
                                createCustom("Danger", "danger"),
                                createCustom("Warning", "warning"),
                                createCustom("success", "success"),
                                createCustom("info", "info")
                        )
                        .code("""
                                Region region = new Region();
                                region.setMinSize(20, 20);
                                region.getStyleClass().addAll("bg-primary" , "round", "bg-insets-5", "border-5");
                                
                                region.getStyleClass().addAll("bg-primary");
                                region.setStyle("-fx-border-color: derive(-primary, 90%);");
                                
                                Label label = new Label(text);
                                label.setGraphic(region);
                                """)

                        .demo(
                                createCustom2("Danger", "danger"),
                                createCustom2("Warning", "warning"),
                                createCustom2("success", "success"),
                                createCustom2("info", "info")
                        )
                        .code("""
                                Label label = new Label(text);
                                label.getStyleClass().addAll( "bg-primary", "text-white", "padding-5", "rounded", "min-size-20", "align-center");
                                """)

                        .demo(
                                createDemo("", "min-size-20", "size-20", "bg-danger", "heart", "padding-5"),
                                createDemo("", "min-size-20", "size-20",  "bg-danger", "star", "padding-5"),
                                createDemo("", "min-size-20", "size-20",  "bg-danger", "star-2", "padding-5"),
                                createDemo("", "min-size-20", "size-20",  "bg-danger", "pac", "padding-5"),
                                createDemo("", "min-size-20", "size-20",  "bg-danger", "leaf", "padding-5"),
                                createDemo("", "min-size-20", "size-20",  "bg-danger", "jelly", "padding-5"),
                                createDemo("", "min-size-20", "size-20",  "bg-danger", "lbl", "padding-5")
                        )
                        .code("""
                                label.getStyleClass().addAll("min-size-20", "size-20",  "bg-danger", "heart", "padding-5");
                                label.getStyleClass().addAll("min-size-20", "size-20",  "bg-danger", "star", "padding-5");
                                label.getStyleClass().addAll("min-size-20", "size-20",  "bg-danger", "star-2", "padding-5");
                                label.getStyleClass().addAll("min-size-20", "size-20",  "bg-danger", "pac", "padding-5");
                                label.getStyleClass().addAll("min-size-20", "size-20",  "bg-danger", "leaf", "padding-5");
                                label.getStyleClass().addAll("min-size-20", "size-20",  "bg-danger", "jelly", "padding-5");
                                label.getStyleClass().addAll("min-size-20", "size-20",  "bg-danger", "lbl", "padding-5");
                                """)




                        .build()
                        .getRoot()
        );

    }

    private Node createCustom2(String text, String color) {
        Label label = new Label(text);
        label.getStyleClass().addAll("bg-" + color, "text-white", "padding-5", "rounded", "min-size-20", "align-center");
        return label;
    }

    private Node createCustom(String text, String color) {

        Region region = new Region();
        region.setMinSize(20, 20);
        region.getStyleClass().addAll("bg-" + color, "round", "bg-insets-5", "border-5");

        region.getStyleClass().addAll("bg-" + color);
        region.setStyle("-fx-border-color: derive(-" + color + ", 90%);");

        Label label = new Label(text);
        label.setGraphic(region);

        return label;
    }

    private Label createDemo(String _text, String... _classes) {
        return createDemo(null, _text, _classes);
    }

    private Label createDemo(Node graphic, String _text, String... _classes) {
        Label text = new Label(_text);
        text.setGraphic(graphic);
        text.getStyleClass().addAll(_classes);
        return text;
    }
}
