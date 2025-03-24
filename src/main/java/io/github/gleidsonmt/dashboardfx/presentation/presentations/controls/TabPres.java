package io.github.gleidsonmt.dashboardfx.presentation.presentations.controls;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  07/03/2025
 */
public class TabPres extends StackPane {
    public TabPres() {
        getChildren().setAll(
                new Tutorial()
                        .indicators()
                        .h2("TabPane", null)
                        .text("A control that allows switching between a group of Tabs. Only one tab is visible at a time. Tabs are added to the TabPane by using the getTabs.")

                        .h3("Install")
                        .code("ThemeProvider.install(root, \n\tCss.COLORS, \n\tCss.TAB_PANE);", "java")
                        // .link([link to explanation]) ir para temas
                        .separator()
                        .demo(createDemo(Side.TOP))
                        .code("""
                                TabPane tabPane = new TabPane();
                                Tab one = new Tab("Example 01", new Label("Tab Content 01"));
                                Tab two = new Tab("Example 02", new Label("Tab Content 02"));
                                tabPane.getTabs().addAll(one, two);
                                """)
                        .h3("Sides")
                        .demo(
                                createDemo(Side.TOP),
                                createDemo(Side.BOTTOM),
                                createDemo(Side.LEFT),
                                createDemo(Side.RIGHT)
                        )
                        .code("""
                                tabPane.setSide(Side.TOP) // default;
                                tabPane.setSide(Side.BOTTOM);
                                tabPane.setSide(Side.LEFT);
                                tabPane.setSide(Side.RIGHT);
                                """)
                        .build().getRoot()
        );
    }

    private TabPane createDemo(Side side) {
        TabPane tabPane = new TabPane();
        tabPane.setSide(side);
        Tab one = new Tab("Example 01" );
        Tab two =new Tab("Example 02");
        one.setContent(container(new Label("Tab Content 01")));
        two.setContent(container(new Label("Tab Content 02")));
        tabPane.getTabs().addAll(one, two);
        return tabPane;
    }

    private StackPane container(Node node) {
        StackPane container = new StackPane(node);
        container.setPadding(new Insets(20));
        return container;
    }
}
