package io.github.gleidsonmt.dashboardfx.presentation.about;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  02/04/2025
 */
public class AboutPres extends StackPane {

    public AboutPres() {
        getChildren().setAll(
          new Tutorial()
                  .h3("Goals")
                  .text("""
                          This projects aims to amplify javafx developers core.
                          Using examples, and multiple components.
                          """)
                  .h3("Non Goals")
                  .text("""
                          This project doesn't pretend to stole ideias or projects.
                          I like an amount of technologies inclusive web designer, sometimes
                          this techniques can be fit in other contexts.
                          """)
                  .build()
                  .getRoot()
        );
    }


}
