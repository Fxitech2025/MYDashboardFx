package io.github.gleidsonmt.dashboardfx.presentation.core;

import io.github.gleidsonmt.dashboardfx.Main;
import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import io.github.gleidsonmt.dashboardfx.utils.TutorialUtils;
import io.github.gleidsonmt.glad.base.Layout;
import io.github.gleidsonmt.glad.base.Root;
import io.github.gleidsonmt.glad.base.RootImpl;
import io.github.gleidsonmt.glad.base.WrapperEffect;
import io.github.gleidsonmt.glad.dialog.alert.AlertType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  20/03/2025
 */
public class Behavior extends StackPane {

    public Behavior() {
//        Layout layout= new Layout();
//        layout.addPoint(event -> {
//
//        });
//        RootImpl ro = new RootImpl(new Layout());
//        ro.behavior().openDrawer();

//        ro.behavior().alert().open();
        getChildren().setAll(
                new Tutorial()
                        .h3("Behavior")
                        .text("""
                                Behavior class has calling the actions on the rootImpl.""")
                        .legend("io.github.gleidsonmt.glad.base.Behavior")
                        .h4("Dialogs", "Behavior")
                        .demo(
                                createDemo(e -> {
                                    Root main = (Root) getScene().getRoot();
                                    Button ok = new Button("Button");
                                    ok.setOnAction(el -> {
                                        main.behavior().dialog().close();
                                    });
                                    VBox content = new VBox(new Text("Lorem ipsum dolor color"), ok);
                                    content.setAlignment(Pos.CENTER);
                                    content.setSpacing(10);
                                    main.behavior().dialog().open(content);

                                })
                        )
                        .code("""
                                Main main = (Main) getScene().getRoot();
                                Button ok = new Button("Button");
                                VBox content = new VBox(new Text("Lorem ipsum dolor color"), ok);
                                main.behavior().dialog().open(content);
                                """)
                        /*   */
                        .h4("Opening", "Behavior")
                        .demo(new Node[]{
                                        createDemo(e -> {
                                                    RootImpl rootImpl = (RootImpl) this.getScene().getRoot();
                                                    rootImpl.behavior().alert().open("About", new Text("Press escape to close."), AlertType.ERROR);
                                                }
                                        ),
                                        createDemo(e -> {
                                                    RootImpl rootImpl = (RootImpl) this.getScene().getRoot();
                                                    rootImpl.behavior().alert().open("About", new Text("Press  to close."), AlertType.INFO);
                                                }
                                        ),
                                        createDemo(e -> {
                                                    RootImpl rootImpl = (RootImpl) this.getScene().getRoot();
                                                    rootImpl.behavior().alert().open("About", new Text("Press  to close."), AlertType.WARNING);
                                                }
                                        ),
                                        createDemo(e -> {
                                                    RootImpl rootImpl = (RootImpl) this.getScene().getRoot();
                                                    rootImpl.behavior().alert().open("About", new Text("Press  to close."), AlertType.SUCCESS);
                                                }
                                        )
                                }
                        )
                        .code("""
                                 rootImpl.behavior().alert().open("About", new Text("Lorem ipsum dolor color"), AlertType.INFO);
                                 rootImpl.behavior().alert().open("About", new Text("Lorem ipsum dolor color"), AlertType.WARNING);
                                 rootImpl.behavior().alert().open("About", new Text("Lorem ipsum dolor color"), AlertType.DANGER);
                                 rootImpl.behavior().alert().open("About", new Text("Lorem ipsum dolor color"), AlertType.SUCCESS);
                                """)
                        .h4("Combine with Wrapper", "Behavior")
                        .demo(createDemo(e -> {
                            RootImpl rootImpl = (RootImpl) this.getScene().getRoot();
                            rootImpl.wrapper().show(WrapperEffect.BLUR);
                            rootImpl.behavior().alert().open("About", new Text("Press  to close."), AlertType.SUCCESS);
                        }))
                        .code("""
                                Root rootImpl = (Root) this.getScene().getRoot();
                                rootImpl.wrapper().show(WrapperEffect.BLUR);
                                rootImpl.behavior().alert().open("About", new Text("Press  to close."), AlertType.SUCCESS);
                                """)
                        .h4("Add Buttons", "Behavior")
                        .text("""
                                The buttons are added in a button bar container.
                                """)
                        .node(TutorialUtils.createLink("See more in Button Bar", "Button Bar"))
                        .demo(createDemo(e -> {
                            RootImpl rootImpl = (RootImpl) this.getScene().getRoot();
                            Button cancel = new Button("Cancel");
                            Button apply = new Button("Apply");
                            cancel.setCancelButton(true);
                            cancel.setOnAction(_ -> {
                                rootImpl.wrapper().hide();
                                rootImpl.behavior().alert().close();
                            });
                            rootImpl.wrapper().show(WrapperEffect.BLUR);
                            rootImpl.behavior().alert().open("About", new Text("Press  to close."), AlertType.SUCCESS, cancel, apply);
                        }))
                        .code("""
                                Button cancel = new Button("Cancel");
                                Button apply = new Button("Apply");
                                rootImpl.behavior().alert().open("About", new Text("Press  to close."), AlertType.SUCCESS, cancel, apply);
                                """)

                        .h4("Close the Alert", "Behavior")
                        .code("""
                                Button cancel = new Button("Cancel");
                                cancel.setOnAction(event -> {
                                    rootImpl.behavior().alert().close();
                                });
                                """)

                        // maybe you change form here, to get from drawer() method
                        .h4("Drawer", "Behavior")
                        .text("""
                                Try to open the drawer.
                                if the width is small the drawer appears from left,
                                but the width is larger nothing happens. 
                                """)
                        .demo(createDemo())
                        .code("rootImpl.behavior().openDrawer();")

                        .build()
                        .getRoot()
        );
    }

    private TextFlow createTextFlow(String... classes) {
        TextFlow textFlow = new TextFlow(new Text(
                "Lotem ipsum dolor color"
        ));
        textFlow.getStyleClass().addAll(classes);
        return textFlow;
    }

    private Node createDemo() {
        Button button = new Button("Click on me!");
        button.setOnAction(e -> {
            RootImpl rootImpl = (RootImpl) button.getScene().getRoot();
            rootImpl.behavior().openDrawer();
        });
        return button;
    }

    private Node createDemo(EventHandler<ActionEvent> event) {
        Button button = new Button("Click on me!");
        button.setOnAction(event);
        return button;
    }
}
