package io.github.gleidsonmt.dashboardfx.drawer;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  10/04/2025
 */
public interface ModuleCreator {

    ObservableList<ModuleCreator> getModules();

    String getName();

    Node getGraphic();

    void setParent(ModuleCreator parent);

    ModuleCreator getParent();

    void setContainer(Pane container) ;

    Pane getContainer();

    boolean isAnimated();
}
