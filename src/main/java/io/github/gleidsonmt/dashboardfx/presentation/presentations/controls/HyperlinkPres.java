package io.github.gleidsonmt.dashboardfx.presentation.presentations.controls;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import io.github.gleidsonmt.dashboardfx.utils.TutorialUtils;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  20/02/2025
 */
public class HyperlinkPres extends StackPane {

    public HyperlinkPres() {

        getChildren().setAll(
                new Tutorial()
                        .indicators()
                        .h2("Hyperlink", null)
                        .text("""
                                An HTML like label which can be a graphic and/or text which responds to rollovers and clicks. When a hyperlink is clicked/pressed isVisited becomes true.
                                A Hyperlink behaves just like a Button.
                                When a hyperlink is pressed and released a ActionEvent is sent, and your application can perform some action based on this event.
                                """)
                        .legend("All classes in (Text) works in the text inside hyperlink.")
                        .legend("All classes in (Region) can by apply in hyperlink.")
//                        .legend("(The base font here is set to Poppins, by default is not apply, but it's better to add all fonts before the app load. At the end you can see the code to add.)")
                        // .link([link to explanation]) ir para temas

                        .demo(createDemo("Hyperlink"))
                        .code("Hyperlink hyperlink = new Hyperlink(\"Lorem ipsum dolor color\");")
                        .h3("Graphic", "Hyperlink")
                        .text("An optional icon for the Labeled.")
                        .node(TutorialUtils.createLink("See more icons in SVGIcon", "SVGIcon"))
                        .demo(
                                createDemo(new SVGIcon(Icon.MENU), "Menu"),
                                createDemo(new SVGIcon(Icon.ARROW_BACK), "Arrow"),
                                createDemo(new SVGIcon(Icon.LOCATION_ON), "Location")
                        )
                        .code("hyperlink.setGraphic(new SVGICon(Icon.MENU));")

                        .h3("Content Display", "Button")
                        .node(TutorialUtils.createLink("See more displays in Label", "Label", "Display"))
                        .demo(createDemo(new SVGIcon(Icon.HOME), "display","display-top", "padding-10"))
                        .code("""
                                Button btn = new Button("Button");
                                btn.getStyleClass().addAll("display-bottom");
                                """)

                        .build()
                        .getRoot()
        );

    }

    private Hyperlink createDemo(String _text, String... _classes) {
        return createDemo(null, _text, _classes);
    }
    private Hyperlink createDemo(Node graphic, String _text, String... _classes) {
        Hyperlink text = new Hyperlink(_text);
        text.setGraphic(graphic);
        text.getStyleClass().addAll(_classes);
        return text;
    }
}
