package io.github.gleidsonmt.dashboardfx.presentation.core;

import io.github.gleidsonmt.dashboardfx.Main;
import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import io.github.gleidsonmt.presentation.Code;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.util.List;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  23/03/2025
 */
public class FlowPres extends StackPane {
    public FlowPres() {
        getChildren().setAll(
                new Tutorial()
                        .h3("Flow")
                        .text("""
                                The main ideia is putting absolute nodes in root.
                                Using stack pane you can add nodes in the main positions, and translate this
                                nodes using insets.
                                """)
                        .legend("io.github.gleidsonmt.glad.base.Flow")
                        .h4("Open", "Flow")
                        .legend("Create a floating button to see different sides.")
                        .demo(
                               new Node[]{
                                       createDemo(Pos.TOP_LEFT, new Insets(20)),
                                       createDemo(Pos.TOP_CENTER, new Insets(20)),
                                       createDemo(Pos.TOP_RIGHT, new Insets(20)),
                                       createDemo(Pos.CENTER_RIGHT, new Insets(20)),
                                       createDemo(Pos.CENTER, new Insets(20)),
                                       createDemo(Pos.CENTER_LEFT, new Insets(20)),
                                       createDemo(Pos.BOTTOM_RIGHT, new Insets(20)),
                                       createDemo(Pos.BOTTOM_CENTER, new Insets(20)),
                                       createDemo(Pos.BOTTOM_LEFT, new Insets(20))
                               }
                        )
                        .code("""
                                    Main main = (Main) getScene().getRoot();
                                    Button btn = new Button();
                                    btn.setGraphic(new SVGIcon(Icon.ADD));
                                    btn.getStyleClass().addAll("size-50", "round", "display-graphic");
                                    // Change the pos
                                    main.flow().openAbsolute(btn, Pos.BOTTOM_RIGHT, new Insets(20));
                                """)
                        .h4("Close", "Flow")
                        .demo(createDemo(e -> {
                            Main main = (Main) getScene().getRoot();
                            main.flow().clear();
                        }))
                        .code("""
                                Main main = (Main) getScene().getRoot();
                                main.flow().clear();
                                // Removing a specific node
                                main.flow().remove(node);
                                """)
                        .build()
                        .getRoot()
        );
    }

    private Node createDemo(EventHandler<ActionEvent> eventEventHandler) {
        Button button = new Button("Click on me!");

        button.setOnAction(eventEventHandler);
        return button;
    }

    private Node createDemo(Pos pos, Insets insets) {
        Button button = new Button("Click on me!");

        button.setOnAction(e -> {
                    Main main = (Main) getScene().getRoot();
                    Button ok = new Button("");
                    ok.setGraphic(new SVGIcon(Icon.ADD));
                    ok.getStyleClass().addAll("round", "size-50", "display-graphic");
                    main.flow().openAbsolute(ok, pos, insets);
                }
        );
        return button;
    }
}
