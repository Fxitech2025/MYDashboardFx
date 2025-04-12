package io.github.gleidsonmt.dashboardfx.presentation.core;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import io.github.gleidsonmt.dashboardfx.utils.Assets;
import io.github.gleidsonmt.dashboardfx.utils.TutorialUtils;
import io.github.gleidsonmt.presentation.Presentation;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  20/03/2025
 */
public class Introduction extends StackPane {

    public Introduction() {
        getChildren().setAll(
                new Tutorial()
                        .h3("Introduction")
                        .text("""
                                The main idea is to create a fast way to create apps, of course there's
                                a lot of techniques to do that, but it's not a normal thing to see in javafx.
                                In a normal day you need ways to get fast to get your design, repeating tasks is the most hating thing daily.
                                This projects expects to add some layers to production by using known patterns.  
                                
                                """)

                        .h3("Start an App", "Introduction")
                        .code("""
                                /**
                                 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
                                 * Create on  20/02/2025
                                 */
                                public class App extends Application {
                                    @Override
                                    public void start(Stage stage) {
                                        Root root = new Root(new Layout(new Button("Welcome")));
                                        Scene scene = new Scene(root, 800, 600);
                                        stage.setScene(scene);
                                        stage.show();
                                    }
                                }
                                """)

                        .h4("Root", "Introduction")
                        .text("""
                                The Root class is an ideia to have stacked components, actual apps has flow components, 
                                usually stacked, like snacks, alerts etc. So the root class is wrapper to StackPane.     
                                """)
                        .legend("io.gleidsonmt.glad.base.Root")

                        .h3("Global Methods", "Root")
                        .text("""
                                These global methods are called when application needs to update the root.
                                Calling notifications and custom alerts.
                                """)
                        .node(TutorialUtils.createLink("Wrapper", "Wrapper"))
                        .node(TutorialUtils.createLink("Flow", "Flow"))
                        .node(TutorialUtils.createLink("Behavior", "Behavior"))

                        .h4("Layout", "Introduction")
                        .text("""
                                The Layout class is the global parts of the application.
                                The combinations of these two layouts, creates an empty region with five separating blocks.
                                """)
                        .legend("io.gleidsonmt.glad.base.Layout")
                        .code("Root root = new Root(new Layout());")
                        .image(Assets.getImage("part3.png"))
                        .text("""
                                As knowing to much nodes cause leaks of memory, using BorderPane or a
                                complex layout can be combined with putting things without modifying the actual view,
                                example dashboards with drawer, aside, navs, footers.. and so on.
                                """)


                        .h3("Installing Themes", "Introduction")
                        .text("Theme provider can install font and css, using enum with their names.")
                        .text("If it's a control replace with the name of the class.")
                        .code("""
                                ...
                                // fonts
                                ThemeProvider.install(scene, Font.POPPINS, Font.INSTAGRAM); 
                                // Css stylesheets
                                ThemeProvider.install(scene,
                                        Css.COLORS,
                                        Css.PROPERTIES,
                                        Css.TYPOGRAPHIC
                                        ...
                                );
                                ...
                                """)
                        .build()
                        .getRoot()
        );
    }
}
