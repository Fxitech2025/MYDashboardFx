package io.github.gleidsonmt.dashboardfx.presentation.core;

import io.github.gleidsonmt.dashboardfx.Main;
import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import io.github.gleidsonmt.glad.base.Layout;
import io.github.gleidsonmt.glad.base.Root;
import io.github.gleidsonmt.glad.base.WrapperEffect;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  21/03/2025
 */
public class Wrapper extends StackPane {
    public Wrapper() {
        getChildren().setAll(
                new Tutorial()
                        .h3("Wrapper")
                        .text("The wrapper interface disposes a region with color to focus on the element stacked.")
                        .legend("io.github.gleidsonmt.glad.base.Wrapper")
                        .legend("Click on it, to hide.")
                        .demo(createDemo())
                        .code("""
                                Main main = (Main) getScene().getRoot();
                                main.wrapper().show();
                                """)
                        .h3("Effect", "Wrapper")
                        .demo(createDemo(WrapperEffect.BLUR))
                        .code("""
                                Main main = (Main) getScene().getRoot();
                                main.wrapper().show(WrapperEffect.BLUR);
                                """)
                        .h4("Closing", "Wrapper")
                        .code("""
                                Main main = (Main) getScene().getRoot();
                                main.wrapper().hide();
                                """)
                        .build()
                        .getRoot()
        );
    }

    private Node createDemo() {
        return createDemo(WrapperEffect.GRAY);
    }
    private Node createDemo(WrapperEffect wrapperEffect) {
        Button button = new Button("Click on me");
        button.setOnAction(e -> {
            Root main = (Root) getScene().getRoot();
            main.wrapper().show(wrapperEffect);
        });
        return button;
    }
}
